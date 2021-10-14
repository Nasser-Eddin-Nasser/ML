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
    return this.httpClient.delete(`${this.REST_API_SERVER}/id/${media.id}`);
  }


  public insertOrUpdateMedia(media: Media) {
    var mediaJson: string = JSON.stringify(media);
    const options = { headers: { 'Content-Type': 'application/json' } };
    return this.httpClient.post(this.REST_API_SERVER, mediaJson, options);
  }


}