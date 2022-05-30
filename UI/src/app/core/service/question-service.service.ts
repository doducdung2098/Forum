import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from '../model/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionServiceService {

  constructor(private http : HttpClient) { }

  findAll(): Observable<any>{
    return this.http.get<Question>("http://127.0.0.1:8082/api/v1/user/questions");
  }

  getQuestionOfTopic(topicId : number): Observable<any>{
    return this.http.get<Question>("http://127.0.0.1:8082/api/v1/user/topic/" + topicId + "/paged/0");
  }

  raiseQuestion(question : any) : Observable<any>{
    return this.http.post<any>("http://127.0.0.1:8082/api/v1/user/raise-question", question);
  }

  searchByKeyword(keyword : any): Observable<any>{
    return this.http.get<Question>("http://127.0.0.1:8082/api/v1/user/search-question?keyword=" + keyword);
  }

  getQuestionById(id : number): Observable<any>{
    return this.http.get<Question>("http://127.0.0.1:8082/api/v1/user/question/" + id);
  }

  addQuestionToTopic(body : any){
    return this.http.post<Question>("http://127.0.0.1:8082/api/v1/user/set-topic", body);
  }

  getQuestionToApprove(): Observable<any>{
    return this.http.get<any>("http://127.0.0.1:8082/api/v1/admin/manage-questions/paged/0");
  }

  approvalQuestion(body : any): Observable<any>{
    return this.http.put<any>("http://127.0.0.1:8082/api/v1/admin/manage-questions/update-question", body)
  }

  deleteQuestion(id : any){
    return this.http.delete("http://127.0.0.1:8082/api/v1/admin/manage-questions/delete/" + id)
  }
}
