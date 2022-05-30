import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnswersServiceService {

  constructor(private http : HttpClient) { }

  getAnswersByQuestionId(id : any): Observable<any>{
    return this.http.get("http://127.0.0.1:8082/api/v1/user/question-answers/" + id + "/paged/0");
  }

  raiseAnswers(answers : any){
    return this.http.post("http://127.0.0.1:8082/api/v1/user/raise-answers", answers)
  }

  getAllAnswersToApprove(): Observable<any>{
    return this.http.get("http://127.0.0.1:8082/api/v1/admin/manage-answers/paged/0")
  }

  approvedAnswers(body : any): Observable<any>{
    return this.http.put("http://127.0.0.1:8082/api/v1/admin/manage-answers/update-answers", body)
  }

  deleteAnswers(id : any){
    return this.http.delete("http://127.0.0.1:8082/api/v1/admin/manage-answers/delete/" + id)
  }
}
