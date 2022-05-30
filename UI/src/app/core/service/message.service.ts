import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http : HttpClient) { }

  getAllMessageByChatboxId(id : any): Observable<any>{
    return this.http.get("http://127.0.0.1:8081/api/v1/user/chatbox/" + id + "/message");
  }

  createMessage(body : any): Observable<any>{
    return this.http.post("http://127.0.0.1:8081/api/v1/user/chatbox/add-message", body)
  }

}
