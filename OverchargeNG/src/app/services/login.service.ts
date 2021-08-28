import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  loggedIn: boolean = false;
  

  constructor(private http: HttpClient) { }

  login(user: User): Observable<User> {
    // console.log("Attempting login: ",user);
    return this.http.post<User>(`http://localhost:8081/login`, user, {responseType: "json", headers: this.headers} );
  }

  getUsername(): string {
    let username = localStorage.getItem("username");

    if (username == '' || username == "Guest" || username == undefined) {
      localStorage.setItem("username", "Guest");
      this.loggedIn = false;
      return "Guest";
    } else {
      return username;
    }
  }

  setUsername(username: string): void {
    if(username != "Guest") {
      this.loggedIn = true;
    }
    localStorage.setItem("username", username);
  }
}
