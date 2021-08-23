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
  closeResult = '';
  username: string = '';
  password: string = '';
  user: User = new User(0,'','',0,0);
  sw1: boolean = false;
  sw2: boolean = false;
  sw3: boolean = false;
  id: any;
 
 

  
  
  @ViewChild('timer')
  timer!: TimerComponent;
  // @ViewChild('cd') 
  // countdown!: CountdownComponent;
  

  constructor(private loginServ: LoginService, private modalService: NgbModal, private cd: ChangeDetectorRef) { 
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

  open(content:any) {

    this.modalService.open(content,
  {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
    this.closeResult =
      `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
    return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
    return 'by clicking on a backdrop';
    } else {
    return `with: ${reason}`;
    }
  }

  login() {

    console.log(this.username);
    console.log(this.password);

    let loginAttempt = new User(0,this.username, this.password,0,0);
    this.loginServ.login(loginAttempt).subscribe(
      (response) => {
        if (response) {
          this.user = response;
          console.log("Response : " + JSON.stringify(this.user.id));

          this.loginServ.setUsername(this.user.username);
          console.log("logged in: ", this.user.username);
          window.localStorage.setItem("userID",String(response.id));
          console.log("User Id saved : " + JSON.stringify(response.id));
          this.sw1 = false
          this.sw2 = true;
          this.sw3 = false;
          window.setTimeout(() => {
            this.modalService.dismissAll();
            this.sw1 = false;
            this.sw2 = false;
            this.sw3 = false;
           }, 1200);
        } else {
          console.log("Invalid login...");
          this.sw1 = true;
          this.sw2 = false;
          this.sw3 = false;
        }
      },
      (error) => {
        console.log("Login Error...");
        this.sw3 = true;
        this.sw1 = false;
        this.sw2 = false;
      })





      //    if(this.user.username == this.username && this.user.password == this.password) {
      //     console.log("Success! Logging in...");
      //     this.responseMessage = "Success! Logging in...";
      //     localStorage.setItem("username", this.user.username);
      //     window.setTimeout(()=>{
      //       location.reload();
      //    }, 1500);

      //    }else {  
      //      console.log("Incorrect credentials");
      //      this.responseMessage = "Incorrect credentials";
      //   }
      // }


     

}
}


