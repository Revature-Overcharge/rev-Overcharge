import { ChangeDetectionStrategy, Component, OnInit, ViewChild } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { TimerComponent } from '../timer/timer.component';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SidenavComponent implements OnInit {

  timerBool: boolean;
  
  @ViewChild('timer')
  timer!: TimerComponent;
  // @ViewChild('cd') 
  // countdown!: CountdownComponent;
  

  constructor(private loginServ: LoginService) { 
    this.timerBool = false;
  }

  ngOnInit(): void { }

  // handleEvent(e: CountdownEvent) {
  //   console.log("Sidenav: "+ e.action)
  //   switch (e.action) {
  //     case 'start':
  //       this.countdown.begin();
  //       break;
  //     case 'pause':
  //       this.countdown.pause();
  //       break;
  //     case 'restart':
  //       this.countdown.restart();
  //       break;
  //     default:
  //       break;
  //   }
  // }

  showTimer(): void {
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

  isGuest() :boolean {
    console.log(this.loginServ.getUsername());
    return !this.loginServ.loggedIn;
  }

}
