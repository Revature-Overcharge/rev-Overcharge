import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginServ: LoginService, private router: Router) { }

  ngOnInit(): void { }

  username: string = '';
  password: string = '';
  responseMessage: string = '';
 

  login() {

    console.log(this.username);

    let loginAttempt = new User(this.username, this.password);
    this.loginServ.login(loginAttempt).subscribe(
      (response) => {
        if (response) {
          const user = response;

          this.loginServ.setUsername(user.username);
          console.log("logged in: ", user.username);
          this.router.navigateByUrl("/home");
          window.localStorage.setItem("userID",String(user.user_id));
          // window.setTimeout(() => {
          //   location.reload();
          // }, 1500);
        } else {
          console.log("Invalid login...");
        }
      },
      (error) => {
        console.log("Login Error...");
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


}
