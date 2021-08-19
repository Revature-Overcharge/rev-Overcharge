import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  changeText: any;
  newText:string = "Daily and Weekly Challenges...";
  username = localStorage.getItem("username") || 'Guest';
  responseMessage: string = '';
  loggedIn : boolean;

  constructor() { 
    this.loggedIn = false;
  }

  ngOnInit(): void {
  }

  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }

  logout(){
    localStorage.setItem("username", 'Guest');
    this.loggedIn = !this.loggedIn;
    this.responseMessage = "Logging out";
    window.setTimeout(()=>{
      location.reload();
   }, 1500);
  }
}
