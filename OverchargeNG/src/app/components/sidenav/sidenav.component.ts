import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {

  timerBool :boolean = false;

  constructor() { }

  ngOnInit(): void {
    this.timerBool = false;
  }

  showTimer() {
    if(this.timerBool == true) {
      this.timerBool = false;
    } else {
      this.timerBool = true;
    }
  }

}
