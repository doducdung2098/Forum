import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './layout/admin/user-list/user-list.component';
import { QuestionListComponent } from './layout/admin/question-list/question-list.component';
import { AnswersListComponent } from './layout/admin/answers-list/answers-list.component';
import { SignUpComponent } from './share/sign-up/sign-up.component';
import { LoginComponent } from './share/login/login.component';
import { ForumComponent } from './layout/user/forum/forum.component';
import { AnswersPageComponent } from './layout/user/answers-page/answers-page.component';
import { RaiseQuestionComponent } from './layout/user/raise-question/raise-question.component';
import { AuthGuard } from './share/guard/auth.guard';
import { UserGuard } from './share/guard/user.guard';
import { ChatboxComponent } from './share/chatbox/chatbox.component';
import { NewChatComponent } from './share/new-chat/new-chat.component';


const routes: Routes = [
  {path: '', redirectTo: '/forum', pathMatch: 'full'},
  {path : 'users-list', component : UserListComponent, canActivate:[AuthGuard, UserGuard]},
  {path : 'questions-list', component : QuestionListComponent, canActivate :[AuthGuard, UserGuard]},
  {path : 'answers-list', component : AnswersListComponent, canActivate :[AuthGuard, UserGuard]},
  {path : 'sign-up', component : SignUpComponent},
  {path : 'login', component : LoginComponent},
  {path : 'forum', component : ForumComponent},
  {path : 'view-answers-page/:id', component : AnswersPageComponent, canActivate :[AuthGuard]},
  {path : 'chatbox/:id', component : ChatboxComponent, canActivate :[AuthGuard]},
  {path : 'raise-question', component : RaiseQuestionComponent, canActivate : [AuthGuard]},
  {path : 'chatbox', component : ChatboxComponent, canActivate : [AuthGuard]},
  {path : 'new-chat', component : NewChatComponent, canActivate : [AuthGuard]}
]
@NgModule({
  declarations: [
  ],
  imports: [CommonModule,RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
