import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from 'app/core/model/question';
import { AnswersServiceService } from 'app/core/service/answers-service.service';
import { QuestionServiceService } from 'app/core/service/question-service.service';

@Component({
  selector: 'app-answers-page',
  templateUrl: './answers-page.component.html',
  styleUrls: ['./answers-page.component.css']
})
export class AnswersPageComponent implements OnInit {

  constructor(private router : ActivatedRoute,
    private questionService : QuestionServiceService,
    private answersService : AnswersServiceService) { }
  question : Question = new Question();
  answersList : any;

  ngOnInit(): void {
     let id = this.router.snapshot.params['id'];
     this.questionService.getQuestionById(id).subscribe(res => {
       this.question = res.question;
        
     })
     this.answersService.getAnswersByQuestionId(id).subscribe(res => {
        this.answersList = res.answers;
    })
  }

  raiseAnswers(questionId : any, content : any){
    const answers = {
      "userDto": JSON.parse(localStorage.getItem("currentUser") + ''),
      "content": content,
      "createdDate":  JSON.stringify(new Date().getTime()),
      "questionDto": this.question,
      "status": 0
    }
      this.answersService.raiseAnswers(answers).subscribe(res => {
        window.location.reload();
      })
  }

}
