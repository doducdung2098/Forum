import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'app/core/model/user';
import { HelperService } from 'app/core/service/helper.service';
import { UserServiceService } from 'app/core/service/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router : Router,
  private userService : UserServiceService,
  private helper : HelperService) { }

  ngOnInit(): void {
  }
  submit = false;
  currentUser : User = new User();
  loginForm = new FormGroup({
    username : new FormControl('',
    [
      Validators.required,
      Validators.minLength(5)
    ]),
    password : new FormControl('',
    [
      Validators.required,
      Validators.minLength(5)
    ]
    )
  })
  get username(){
    return this.loginForm.get('username')
 }

  get password(){
   return this.loginForm.get('password')
 }

 onSubmit(){
  this.submit = true;
  if(this.loginForm.valid){
      const user = {
        "username" : this.loginForm.value.username,
        "password" : this.loginForm.value.password
      }
      this.userService.processLogin(user).subscribe(result =>{
          this.currentUser = result.user;
          console.log(this.currentUser);
          if (this.currentUser != null && this.currentUser.role == "customer"){
            console.log(this.currentUser);
            
              alert("Login successfully");
              this.helper.setData(this.currentUser)
              this.router.navigate(['forum']).then(() => {
                window.location.reload()
              })
          }else if( this.currentUser != null  && this.currentUser.role == "admin"){
            alert("Login successfully");
            this.helper.setData(this.currentUser)
            this.router.navigate(['questions-list']).then(() => {
              window.location.reload()
            })
          }else{
            alert("Login fail!");
          }
      })
  }else{
    alert("Login fail!");
  }
 }

 goSignUpPage(){
   this.router.navigate(['/sign-up']);
 }
}
