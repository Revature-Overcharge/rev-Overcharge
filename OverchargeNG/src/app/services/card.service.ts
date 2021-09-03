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
    return this.http.get<Card[]>('http://34.203.28.82:8081/decks/' + id + '/cards');
  }

  addCard(id: number, card: Card): Observable<Card>{
    return this.http.post<Card>('http://34.203.28.82:8081/decks/' + id + '/cards', card, { headers: this.postHeaders});
  }

  deleteCard(id: number): Observable<boolean>{
    return this.http.delete<boolean>('http://34.203.28.82:8081/cards/' + id);
  }
}
