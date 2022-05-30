import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class HelperService {

  constructor() { }

setData(user: User){
    localStorage.setItem('currentUser', JSON.stringify(user))
}

getData(){
  return localStorage.getItem('currentUser')
}

removeData() {
  localStorage.removeItem('currentUser')
}

checkLocalStorageStatus(){
 if(localStorage.getItem('currentUser') === null){
    return false;
 }
 return true;
}
}
