import { ChangeDetectorRef, Component, Input, OnInit, PipeTransform } from '@angular/core';
import { Media } from 'src/Model/Media';
import { DataService } from '../data.service';

@Component({
  selector: 'app-media-list',
  templateUrl: './media-list.component.html',
  styleUrls: ['./media-list.component.css']
})
export class MediaListComponent implements OnInit {
  router: any;

  constructor(private dataService: DataService, private cdr: ChangeDetectorRef) { }

  medias: Media[] = [];
  filteredMedias: Media[] = [];
  selectedContact: any = '';
  searchTerm: string = '';

  ngOnInit(): void {
    this.getData();
  }

  onSearch(event: any): void {
    const inputValue = event.target.value;
    if (inputValue !== '')
      this.filteredMedias = this.medias.filter((x: Media) => (x.id === inputValue || x.name.includes(inputValue) || x.author.includes(inputValue) || x.description.includes(inputValue)
        || x.type === (inputValue) || x.uploadBy.includes(inputValue)));
    else
      this.filteredMedias = this.medias;
  }

  private getData(): Array<Media> {
    this.medias = [];
    this.dataService.getMedias().subscribe((elements: any) => {
      elements.forEach((res: any) => {
        this.medias.push(new Media({ id: res.id, name: res.name, description: res.description, uploadBy: res.uploadBy, author: res.author, uploadDate: res.uploadDate, type: res.type }));
      });

    });
    this.cdr.detectChanges();
    this.filteredMedias = this.medias;
    return this.filteredMedias;
  }


  public getContacts(): Array<Media> {
    return this.getData();
  }
  public selectContact(media: any): void {
    if (this.selectedContact !== '' && this.selectedContact.id === media.id)
      this.selectedContact = '';
    else
      this.selectedContact = media;
  }
  public getDesplayDescription(description: string): string {
    return description.replace(/\\n/g, '<br/>');

  }

  public deleteMedia(media: any): void {
    if (confirm("Are you sure to delete: " + media.name)) {
      this.dataService.deleteMediaById(media).subscribe((data) => {
        this.getContacts();
      });

    }

  }


}
