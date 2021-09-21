import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Card } from '../models/card';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  constructor(private http: HttpClient) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getCardsByDeckId(id: number): Observable<Card[]>{
    console.log("getCardsByDeckId()");
    return this.http.get<Card[]>('http://localhost:8081/decks/' + id + '/cards');
  }

  addCard(id: number, card: Card): Observable<Card>{
    console.log("card.service.ts: addCard()");
    return this.http.post<Card>('http://localhost:8081/decks/' + id + '/cards', card, { headers: this.postHeaders});
  }

  updateCard(id: number, card: Card): Observable<Card>{
    console.log("card.service.ts: updateCard()");
    return this.http.put<Card>('http://localhost:8081/cards/' + id, card);
  }

  deleteCard(id: number): Observable<boolean>{
    console.log("deleteCard()");
    return this.http.delete<boolean>('http://localhost:8081/cards/' + id);
  }
}