import { Component, OnInit } from '@angular/core';
import { QuestionServiceService } from 'app/core/service/question-service.service';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {

  constructor(private questionService : QuestionServiceService) { }
  questionList : any;

  ngOnInit(): void {
    this.questionService.getQuestionToApprove().subscribe(result => {
      this.questionList = result.questions;
      console.log(this.questionList);
    })
  }

  approved(id : any){
      const body = {
        "questionId" : id,
        "status" : 1
      }
      this.questionService.approvalQuestion(body).subscribe(res => {
        alert("approved question id = "  + id);
        window.location.reload();
      });
  }
  delete(id : any){
    this.questionService.deleteQuestion(id).subscribe(res => {
      alert("Deleted question id = " + id);
      window.location.reload()
    })
  }
}
