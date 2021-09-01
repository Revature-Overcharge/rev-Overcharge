import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})

export class ObjectivesService {

  constructor( private http: HttpClient) { }

  getObjectives(){
    return this.http.get<User>('http://34.203.28.82:8081/users/' + localStorage.getItem("userID") + '/objectives');
  }
}
