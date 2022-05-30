import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from 'app/core/service/user-service.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor(private userService : UserServiceService,
    private router : Router) { }

  ngOnInit(): void {
  }
  submit = false;
  SignUpForm = new FormGroup({
    username : new FormControl('',
    [
      Validators.required,
      Validators.minLength(8)
    ]),
    password : new FormControl('',
    [
      Validators.required,
      Validators.minLength(8)
    ]
    ),
    email : new FormControl('',
    [
      Validators.required,
      Validators.email
    ]),
    phone : new FormControl('',[
      Validators.required
    ]),
    address : new FormControl('',[
      Validators.required
    ]),
    role : new FormControl('', [
      Validators.required
    ])
  })

  get username(){
    return this.SignUpForm.get('username')
 }

  get password(){
   return this.SignUpForm.get('password')
 }
 
 get email(){
   return this.SignUpForm.get('email')
 }

 get phone(){
   return this.SignUpForm.get('phone')
 }

 get address(){
   return this.SignUpForm.get('address')
 }

 onSubmit(){
   this.submit = true;
    if(this.SignUpForm.valid){
      const user = {
          "username" : this.SignUpForm.value.username,
          "password" : this.SignUpForm.value.password,
          "email": this.SignUpForm.value.email,
          "phone": this.SignUpForm.value.phone,
          "role": this.SignUpForm.value.role
      }
      this.userService.processRegister(user).subscribe(result => {
        alert("Register successfully!")
        this.userService.saveUserToChatboxModule(user).subscribe();
        this.userService.saveUserToQAModule(user).subscribe();
        this.router.navigate(['login']).then(() => {
          window.location.reload();
        })
      })
      

    }else{
      alert("register fail!");
    }
 }
}
