import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './share/header/header.component';
import { FooterComponent } from './share/footer/footer.component';
import { UserListComponent } from './layout/admin/user-list/user-list.component';
import { QuestionListComponent } from './layout/admin/question-list/question-list.component';
import { AnswersListComponent } from './layout/admin/answers-list/answers-list.component';
import { AppRoutingModule } from './app-routing.module';
import { SignUpComponent } from './share/sign-up/sign-up.component';
import { LoginComponent } from './share/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ForumComponent } from './layout/user/forum/forum.component';
import { HttpClientModule } from '@angular/common/http';
import { AnswersPageComponent } from './layout/user/answers-page/answers-page.component';
import { RaiseQuestionComponent } from './layout/user/raise-question/raise-question.component';
import { ChatboxComponent } from './share/chatbox/chatbox.component';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';
import { NewChatComponent } from './share/new-chat/new-chat.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    UserListComponent,
    QuestionListComponent,
    AnswersListComponent,
    SignUpComponent,
    LoginComponent,
    ForumComponent,
    AnswersPageComponent,
    RaiseQuestionComponent,
    ChatboxComponent,
    NewChatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MdbDropdownModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
