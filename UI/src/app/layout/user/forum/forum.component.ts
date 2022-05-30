import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from 'app/core/model/question';
import { QuestionServiceService } from 'app/core/service/question-service.service';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {

  constructor(private questionService : QuestionServiceService,
    private router : Router) { }
  
  questionList : Question[] = [];
  topic: any;

  ngOnInit(): void {
      this.questionService.findAll().subscribe(result => {
          this.questionList = result.questions;
      })
  }

  getAllQuestion(){
    this.questionService.findAll().subscribe(result => {
      this.questionList = result.questions;
  })
  }

  search(keyword: any){
      this.questionService.searchByKeyword(keyword).subscribe(result => {
          this.questionList = result.question;
      })
  }

  viewQuestion(id : number){
    this.router.navigate([`/view-answers-page/${id}`])
  }

  getQuestionOfTopic(topic : number){
      this.questionService.getQuestionOfTopic(topic).subscribe(result => {
        this.questionList = result.question;
        this.topic = topic
      })
  }

  goRaiseQuestionPage(){
    this.router.navigate(['/raise-question'])
  }
}
