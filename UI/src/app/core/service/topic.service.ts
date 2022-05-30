import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TopicService {

  constructor(private http : HttpClient) { }

  getTopicById(id : any): Observable<any>{
    return this.http.get("http://127.0.0.1:8082/api/v1/user/get-topic/" + id);
  }
}
