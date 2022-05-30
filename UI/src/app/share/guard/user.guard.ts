import { Injectable } from '@angular/core';
import {  CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {

  constructor(private router: Router) { }

  canActivate(): boolean {
    let user : any = JSON.parse(localStorage.getItem("currentUser") + '');
    if(user.role == "admin"){
      return true;
    }else{
      this.router.navigate(['forum']);
      return false;
    }
    
  }
  
}
