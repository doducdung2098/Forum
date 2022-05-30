import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChatboxService } from 'app/core/service/chatbox.service';
import { MessageService } from 'app/core/service/message.service';
import { UserServiceService } from 'app/core/service/user-service.service';

@Component({
  selector: 'app-new-chat',
  templateUrl: './new-chat.component.html',
  styleUrls: ['./new-chat.component.css']
})
export class NewChatComponent implements OnInit {

  constructor(private userService : UserServiceService,
    private chatboxService : ChatboxService,
    private messageService : MessageService,
    private router : Router) { }

  userList : any;
  currentUser : any;
  chatbox: any;

  ngOnInit(): void {
    this.userService.getAlllUser().subscribe(res => {
      this.userList = res.users
    })
    this.currentUser = this.userService.getCurrentUser();
  }

  chatwith(user : any){
      const users = {
        "userId1": this.currentUser.userId,
        "userId2": user.userId
      }
      console.log(users);
      const newChatbox = {
        "createdDate": JSON.stringify(new Date().getTime())
      }
      
      this.chatboxService.getChatboxIdByUserId(users).subscribe(res =>{
          if(res.userChatbox != null){
              this.chatbox = res.userChatbox[0].chatbox;
              this.router.navigate([`/chatbox/${this.chatbox.id}`]).then(()=> 
              window.location.reload())
          }else{
              console.log("create chatbox");
              this.chatboxService.createChatbox(newChatbox).subscribe(res => {
                this.chatbox = res.chatbox;
                let user_chatbox1 = {
                  "lastUpdate": JSON.stringify(new Date().getTime()),
                  "user": this.currentUser,
                  "chatbox": this.chatbox
                }
                console.log(user_chatbox1);
                this.chatboxService.createUserChatbox(user_chatbox1).subscribe(res => console.log(res));
                let user_chatbox2 = {
                  "lastUpdate": JSON.stringify(new Date().getTime()),
                  "user": user,
                  "chatbox": this.chatbox
                }
                console.log(user_chatbox2);
                
                this.chatboxService.createUserChatbox(user_chatbox2).subscribe(res => console.log(res));
                const body = {
                  "content" : "hi",
                  "createdDate" :  new Date().getTime().toString(),
                  "chatbox" : this.chatbox,
                  "user" : this.currentUser
                }
                this.messageService.createMessage(body).subscribe(res => console.log(res));
                this.router.navigate([`/chatbox/${this.chatbox.id}`]).then(() =>
                  window.location.reload()
                )
              })
          }
      })
  }

}
