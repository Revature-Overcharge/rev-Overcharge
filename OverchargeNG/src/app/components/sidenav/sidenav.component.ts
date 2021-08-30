import { ChangeDetectionStrategy, Component, OnInit, ViewChild, ChangeDetectorRef, Input } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { TimerComponent } from '../timer/timer.component';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SidenavComponent implements OnInit {

  timerBool: boolean;
  id: any;
 
  @ViewChild('timer')
  timer!: TimerComponent;
  loginPoints: boolean;  

  constructor(private loginServ: LoginService, private cd: ChangeDetectorRef) { 
    this.timerBool = false;
  }

  ngOnInit(): void {
    this.log();
    this.id = setInterval(() => {
      this.log(); 
    }, 1000);
   }

   log(){
    this.cd.detectChanges();
   }

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

    // console.log(this.loginServ.getUsername());
    if (localStorage.getItem("username") === "Guest") {
      return true;
    } else{
      return false;
    }
  }
}


