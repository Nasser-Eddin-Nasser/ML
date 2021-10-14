import { Component, OnInit } from '@angular/core';
import { Media } from 'src/Model/Media';
import { DataService } from '../data.service';

@Component({
  selector: 'app-media-insert',
  templateUrl: './media-insert.component.html',
  styleUrls: ['./media-insert.component.css']
})
export class MediaInsertComponent implements OnInit {

  constructor(private dataService: DataService) { }

  name: string = '';
  author: string = '';
  description: string = '';
  uploadBy: string = '';
  uploadDate: Date = new Date;
  type: string = 'Unknown';

  ngOnInit(): void {
  }
  getValueTest(): string {
    var myDate = new Date();
    var myDateString = myDate.getDay() + "-" + (myDate.getMonth() < 12 ? myDate.getMonth() + 1 : 1) + "-" + myDate.getFullYear() + " " + myDate.getHours() + ":" + myDate.getMinutes();
    return myDateString;
  }

  setName(event: any): void {
    const inputValue = event.target.value;
    this.name = inputValue;
  }
  setAuthor(event: any): void {
    const inputValue = event.target.value;
    this.author = inputValue;
  }
  setDescription(event: any): void {
    const inputValue = event.target.value;
    this.description = inputValue;
  }
  setUploadBy(event: any): void {
    const inputValue = event.target.value;
    this.uploadBy = inputValue;
  }

  setType(event: any): void {
    const inputValue = event.target.value;
    this.type = inputValue;
  }


  submit(): void {
    console.log(this.name);
    var media: Media = new Media({ name: this.name, author: this.author, description: this.description, uploadBy: this.uploadBy, uploadDate: this.uploadDate, type: this.type });
    this.dataService.insertOrUpdateMedia(media).subscribe();
  }

}