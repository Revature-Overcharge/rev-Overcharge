import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginServ: LoginService) { }

  ngOnInit(): void {
  }

  username: string = '';
  password: string = '';
  responseMessage: string = '';
 

  login() {

    console.log(this.username);
    this.loginServ.getUser(this.username).subscribe(
      (response) => {
         const user = response
         console.log(user);
         if(user.username == this.username && user.password == this.password) {
          console.log("Success! Logging in...");
          this.responseMessage = "Success! Logging in...";
          localStorage.setItem("username", user.username);
          window.setTimeout(()=>{
            location.reload();
         }, 1500);

         }else {  
           console.log("Incorrect credentials");
           this.responseMessage = "Incorrect credentials";
        }
      }
    )
  }


}
