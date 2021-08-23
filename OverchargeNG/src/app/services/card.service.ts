import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Card } from '../models/card';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  constructor(private http: HttpClient) { }


  getCardsByDeckId(id: number): Observable<Card[]>{
    return this.http.get<Card[]>('http://localhost:8080/decks/' + id + '/cards');
  }
}
