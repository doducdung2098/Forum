import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HelperService } from 'app/core/service/helper.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private helper : HelperService,
    private router : Router) { }
  currentUser  : any = null;
  showTopic = true;


  ngOnInit(): void {
      this.currentUser = JSON.parse(this.helper.getData() + "");
      if(this.isCustomer()){
        this.showTopic = false;
      }else if(this.currentUser == null){
        this.showTopic = false;
      }else{
        this.showTopic = true;
      }
  }

  isCustomer(){
    if(!this.helper.checkLocalStorageStatus()){
      return false;
    }else if(this.currentUser.role == 'customer'){
      return true;
    }else{
      return false;
    }
  }

  logout(){
    this.showTopic = false;
    localStorage.clear();
    this.router.navigate(['forum']).then(() => {
      window.location.reload();
    })
  }

}
