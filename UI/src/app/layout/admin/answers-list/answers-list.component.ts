import { Component, OnInit } from '@angular/core';
import { AnswersServiceService } from 'app/core/service/answers-service.service';

@Component({
  selector: 'app-answers-list',
  templateUrl: './answers-list.component.html',
  styleUrls: ['./answers-list.component.css']
})
export class AnswersListComponent implements OnInit {

  constructor(private answersService : AnswersServiceService) { }

  answersList : any;

  ngOnInit(): void {
    this.answersService.getAllAnswersToApprove().subscribe(res => {
      this.answersList = res.answers;
    })
  }

  approved(id : number){
      const body = {
        "answersId" : id,
        "status" : 1
      }

      this.answersService.approvedAnswers(body).subscribe(res => {
        alert("approved answers id = " + id);
        window.location.reload();
      })
  }

  delete(id : any){
    this.answersService.deleteAnswers(id).subscribe(res => {
      alert("Deleted answers id = " + id);
      window.location.reload()
    })
  }
}
