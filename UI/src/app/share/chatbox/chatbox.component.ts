import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Stomp } from '@stomp/stompjs';
import { ChatboxService } from 'app/core/service/chatbox.service';
import { HelperService } from 'app/core/service/helper.service';
import { MessageService } from 'app/core/service/message.service';
import { UserServiceService } from 'app/core/service/user-service.service';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-chatbox',
  templateUrl: './chatbox.component.html',
  styleUrls: ['./chatbox.component.css']
})
export class ChatboxComponent implements OnInit {

  constructor(private chatboxService : ChatboxService,
    private helper : HelperService,
    private messageService : MessageService,
    private userService : UserServiceService,
    private router : ActivatedRoute) { }

  user_chatbox : any = null;
  currentUser  : any = null;
  user : any;
  messages : any = null;
  chatbox : any = null;
  name_chatbox : any;
  chatbox_id : any = null;
  stompClient : any;
  chatForm = new FormGroup({
    input : new FormControl('')
  })

  searchForm = new FormGroup({
    input : new FormControl('')
  })

  ngOnInit(): void {
    this.chatbox_id = this.router.snapshot.params['id'];
    
    if(this.chatbox_id != null){
      this.messageService.getAllMessageByChatboxId(this.chatbox_id).subscribe(res => {
        this.messages = res.messages;
      })
    }
    this.currentUser = JSON.parse(this.helper.getData() + "");
    this.chatboxService.getAllUserChatboxByUserId(this.currentUser.userId).subscribe(res => {
      this.user_chatbox = res.userChatbox
      this.initializeChat();
     })

    // setInterval(() => {            
    //   if(this.chatbox !=null ){
    //     this.messageService.getAllMessageByChatboxId(this.chatbox.id).subscribe(res => {
    //       this.messages = res.messages;   
    //     })
    //   }
    // }, 1000)


  }

  getAllChatbox(){
    this.chatboxService.getAllUserChatboxByUserId(this.currentUser.userId).subscribe(res => {
        this.user_chatbox = res.userChatbox
    })
  }

  getAllMessageByChatboxId(id : any){
    this.messageService.getAllMessageByChatboxId(id).subscribe(res => {
      this.messages = res.messages;
    })
    
  }

  // createMessage(chatbox : any){
  //   this.chatbox = chatbox;
  //   const body = {
  //     "content" : this.chatForm.value.input,
  //     "createdDate" :  new Date().getTime().toString(),
  //     "chatbox" : chatbox,
  //     "user" : this.currentUser
  //   }
  //   console.log(body);
  
  //   this.messageService.createMessage(chatbox).subscribe();
  //   this.chatForm.reset();

  // }
  searchUsername(){
     let keyword = this.searchForm.value.search;
     this.userService.findByUsername(keyword).subscribe(res => {
       this.user = res.user;
     })
  }

  initializeChat(): void {
    const socket = new SockJS('http://localhost:8081/chat-websocket');
    console.log(Stomp.over(socket));
    
    this.stompClient = Stomp.over(socket);
    this.stompClient.connect({}, () => {
      this.stompClient.subscribe('/chatbox', (res: any) => {
        if (res)
          this.messages.push(JSON.parse(res.body).body.message);
          console.log(JSON.parse(res.body).body.message.content);
          
      });
    });
  }

  sendMessage(chatbox : any): void {  
   const message = this.chatForm.value.input;
    if (message && message != '' && this.stompClient != null) {
      const body = {
        "content" : this.chatForm.value.input,
        "createdDate" :  new Date().getTime().toString(),
        "chatbox" : chatbox,
        "user" : this.currentUser
      }
      console.log(message);
      console.log(body);
      this.stompClient.send('/app/message', {}, JSON.stringify(body));
      this.chatForm.reset();
    }
  }
}
