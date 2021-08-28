import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { LoginService } from 'src/app/services/login.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap'

@Component({
  selector: 'modal-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  username: string = '';
  password: string = '';
  responseMessage: string = '';
  responseAttempted: boolean = false;
  loginPoints: boolean = false;
  modalRef: any;

  constructor(private loginServ: LoginService, private modalServ: NgbModal, private router: Router) { }

  ngOnInit(): void { }

  login() {

    console.log(this.username);

    let loginAttempt = new User(0 , this.username, this.password, 0 , 100);
    this.loginServ.login(loginAttempt).subscribe(
      (response) => {
        if (response) {
          const user = response;
          console.log(user);

          if(user.objectives.length != 0){
            this.loginPoints = true;
          }

          this.loginServ.setUsername(user.username);
          console.log("logged in: ", user.username);
          this.router.navigateByUrl("/home");
          this.setResponseMessage("success");
          window.localStorage.setItem("userID",String(user.id));
          // window.setTimeout(() => {
          //   location.reload();
          // }, 1500);
        } else {
          console.log("Invalid login...");
          this.setResponseMessage("fail");
        }
      },
      (error) => {
        console.log("Login Error...");
        this.setResponseMessage("error");
      }

        //  const user = response;
        //  console.log(user);

        //  if(user.username == this.username && user.password == this.password) {
        //   console.log("Success! Logging in...");
        //   this.responseMessage = "Success! Logging in...";
        //   localStorage.setItem("username", user.username);
        //   window.setTimeout(()=>{
        //     location.reload();
        //  }, 1500);

        //  }else {  
        //    console.log("Incorrect credentials");
        //    this.responseMessage = "Incorrect credentials";
        // }
      // }
    )
  }

  setResponseMessage(input: string) {
    this.responseAttempted = true;
    switch (input) {
      case "success":
        this.responseMessage = "Success! Logging in...";
        break;
      case "fail":
        this.responseMessage = "Incorrect credentials";
        break;
      case "error":
        this.responseMessage = "Login Error...";
        break;
    }
  }
}
