import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  username: string = "";
  password: string = "";
  invalidLogin: boolean = false;

  login() {
    console.log(this.username);
    console.log(this.password);
  }
}
