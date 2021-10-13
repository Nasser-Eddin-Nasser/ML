import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { Media } from 'src/Model/Media';
import { DataService } from '../data.service';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {
  router: any;

  constructor(private dataService: DataService, private cdr: ChangeDetectorRef) { }

  medias: Media[] = [];
  selectedContact: any = '';

  ngOnInit(): void {
    this.getData();
  }

  private getData(): Array<Media> {
    this.medias = [];
    this.dataService.getMedias().subscribe((elements: any) => {
      elements.forEach((res: any) => {
        this.medias.push(new Media({ id: res.id, name: res.name, description: res.description, uploadBy: res.uploadBy, author: res.author, uploadDate: res.uploadDate, type: res.type }));
      });

    });
    this.cdr.detectChanges();
    return this.medias;
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

  public deleteMedia(media: any): void {
    if (confirm("Are you sure to delete: " + media.name)) {
      this.dataService.deleteMediaById(media).subscribe((data) => {
        this.getContacts();
      });

    }

  }

}
