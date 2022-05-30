import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http : HttpClient) { }
  user : any = null;

  processLogin(user : any): Observable<any>{
    return this.http.post<any>("http://127.0.0.1:8083/api/v1/auth/login", user);
  }

  getCurrentUser(){
    if(localStorage.getItem('currentUser')) {
      this.user = JSON.parse(localStorage.getItem('currentUser') + '');
    }
    return this.user;
  }

  processRegister(user : any){
    return this.http.post("http://127.0.0.1:8083/api/v1/auth/register", user);
  }

  saveUserToChatboxModule(user : any){
    return this.http.post("http://127.0.0.1:8081/api/v1/user/register", user);
  }

  saveUserToQAModule(user : any){
    return this.http.post("http://127.0.0.1:8082/api/v1/user/register", user)
  }

  findByUsername(username : any): Observable<any>{
    return this.http.get<any>("http://127.0.0.1:8081/api/v1/user/chatbox/search?keyword=" + username)
  }

  getAlllUser(): Observable<any>{
    return this.http.get("http://127.0.0.1:8081/api/v1/user/users/paged/0");
  }
}
