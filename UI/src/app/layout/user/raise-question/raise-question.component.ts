import { getLocaleDateTimeFormat } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { QuestionServiceService } from 'app/core/service/question-service.service';
import { TopicService } from 'app/core/service/topic.service';

@Component({
  selector: 'app-raise-question',
  templateUrl: './raise-question.component.html',
  styleUrls: ['./raise-question.component.css']
})
export class RaiseQuestionComponent implements OnInit {

  constructor(private questionService : QuestionServiceService, 
    private router : Router,
    private topicService : TopicService) {}
  submit = false;

  ngOnInit(): void {
  }

  questionForm = new FormGroup({
    title : new FormControl('', [
      Validators.required
    ]),
    content : new FormControl('', [
      Validators.required
    ]),
    img : new FormControl('', [
      Validators.required
    ]),
    topic : new FormControl('', [
      Validators.required
    ])
  })

  get title(){
    return this.questionForm.get('title');
  }

  get content(){
    return this.questionForm.get('content');
  }

  get img(){
    return this.questionForm.get('img');
  }

  get topic(){
    return this.questionForm.get('topic');
  }

  onSubmit(){
    if(this.questionForm.valid){
      const question = {
        "title" : this.questionForm.value.title ,
        "content" : this.questionForm.value.content,
        "createdDate" : new Date().getTime().toString(),
        "img" : this.questionForm.value.img.replace(/C:\\fakepath\\/,""),
        "status" : 0,
        "user" : JSON.parse(localStorage.getItem("currentUser") + '') 
      }
    console.log(new Date().getTime().toString());
    
    let topic;
      
    
    this.questionService.raiseQuestion(question).subscribe(result1 =>{
      this.questionService.getQuestionOfTopic(this.questionForm.value.topic).subscribe(result => {
        const body = {
          "question": result1.question,
          "topic": result.topic
        }
        this.questionService.addQuestionToTopic(body).subscribe();
      })
        alert("Raise question successfully!");
        this.router.navigate(['forum']).then(() =>{
          window.location.reload();
        })
    });

    
    }else{
      alert("Form invalid!")
    }
  }
}
