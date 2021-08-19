import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../beans/User';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  getUser(param: string): Observable<User> {
    console.log(param);

    return this.http.get<User>(`http://localhost:8080/user/username?username=${param}`, {responseType: "json"} );
  }


}
