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
    this.timerBool = !this.timerBool;
    let timerEl = document.getElementById("timerContainer");

    if(this.timerBool == false) {
      //here we need to grab the element from the document and set its display value to none
      //this should get the effect that the timer still exists but is just hidden from us.
      if(timerEl != null) {
        timerEl.style.display = "none";
      }
    } else {
      if(timerEl != null) {
        timerEl.style.display = "block";
      }
    }
  }

}
