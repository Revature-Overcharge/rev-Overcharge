import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  changeText: any;
  newText:string = "Daily and Weekly Challenges...";
  responseMessage: string = '';
  loggedIn : boolean;

  constructor(private loginServ: LoginService, private router: Router) { }

  ngOnInit(): void { }

  toggleSidebar(): void {
    this.toggleSidebarForMe.emit();
  }

  getUsername(): string {
    this.loggedIn = this.loginServ.loggedIn;
    return this.loginServ.getUsername();
  }

  logout(): void {
    this.loggedIn = !this.loggedIn;
    this.loginServ.setUsername('Guest');
    this.responseMessage = "Logging out";
    this.router.navigateByUrl("/login");
  }
}
