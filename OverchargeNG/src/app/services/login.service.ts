import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  getUser(param: string): Observable<User> {
    console.log(param);

    return this.http.get<User>(`http://localhost:8080/h2/username=${param}`, {responseType: "json"} );
  }


}
