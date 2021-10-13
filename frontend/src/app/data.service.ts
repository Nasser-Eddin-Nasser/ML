import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Media } from 'src/Model/Media';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private REST_API_SERVER = "http://localhost:8080/media";

  constructor(private httpClient: HttpClient) { }

  public sendGetRequest() {
    return this.httpClient.get(this.REST_API_SERVER);
  }

  getMedias(): Observable<Media[]> {
    return this.httpClient.get<Media[]>(`${this.REST_API_SERVER}`)
  }

  public deleteMediaById(media: Media): Observable<any> {
    console.log("test");
    console.log(`${this.REST_API_SERVER}/id/${media.id}`);
    return this.httpClient.delete(`${this.REST_API_SERVER}/id/${media.id}`);
    // return this.httpClient.delete('http://localhost:8080/media/id/2');
  }

}