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
    return this.http.get<Card[]>('http://localhost:8081/decks/' + id + '/cards');
  }

  addCard(id: number, card: Card): Observable<Card>{
    return this.http.post<Card>('http://localhost:8081/decks/' + id + '/cards', card, { headers: this.postHeaders});
  }

  deleteCard(id: number): Observable<boolean>{
    return this.http.delete<boolean>('http://localhost:8081/cards/' + id);
  }
  updateCard(id: number, card: Card): Observable<Card>{
    console.log("before the return");
    return this.http.put<Card>('http://localhost:8081/cards/', card);
}
}
