import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatboxService {

  constructor(private htpp : HttpClient) { }

  getAllUserChatboxByUserId(id : number): Observable<any>{
    return this.htpp.get<any>("http://127.0.0.1:8081/api/v1/user/user-chatbox/user-id/" + id);
  }

  getChatboxIdByUserId(userIds : any): Observable<any>{
    return this.htpp.post<any>("http://127.0.0.1:8081/api/v1/user/user-chatbox/check-exist", userIds)
  }

  createChatbox(chatbox : any): Observable<any>{
    return this.htpp.post<any>("http://127.0.0.1:8081/api/v1/user/create-chatbox", chatbox);
  }

  createUserChatbox(userChatbox: any): Observable<any>{
    return this.htpp.post<any>("http://127.0.0.1:8081/api/v1/user/user-chatbox/create-user-chatbox", userChatbox);
  }
}
