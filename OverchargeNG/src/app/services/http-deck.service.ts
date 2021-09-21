import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Deck } from '../models/deck';

@Injectable({
  providedIn: 'root'
})
export class HttpDeckService {

  constructor(private http: HttpClient) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getAllDecks(): Observable<Deck[]> {
    return this.http.get<Deck[]> ('http://localhost:8081/decks');
  }

  getDeckById(id: number): Observable<Deck> {
    return this.http.get<Deck> ('http://localhost:8081/decks/' + id);
  }

  getDeckByTagId(id: number): Observable<Deck[]> { 
    return this.http.get<Deck[]>(`http://localhost:8081/decksByTag?tagId=${id}`);
  }

  getDeckByTitle(title: string): Observable<Deck> {
    return this.http.get<Deck> ('http://localhost:8081/decks/title?' + title);
  }

  addDeck(deck: any): Observable<Deck> {
    return this.http.post<Deck>('http://localhost:8081/decks/', deck, { headers: this.postHeaders });
  }

  updateDeck(deck: Deck): Observable<Deck> {
    return this.http.put<Deck>('http://localhost:8081/decks/' + deck.id, deck, { headers: this.postHeaders });
  }

  updateDeckAndCards(deck: Deck): Observable<Deck> {
    return this.http.put<Deck>('http://localhost:8081/decks/' + deck.id + '/cards', deck, { headers: this.postHeaders });
  }

  deleteDeck(id: number): Observable<boolean>{
    return this.http.delete<boolean>('http://localhost:8081/decks/' + id);
  }
  setDeckTags(id:number, tags:Number[]): Observable<Deck>{
    return this.http.put<Deck>(`http://localhost:8081/setDeckTags/${id}`, {
      'tagsId': tags
  
  }, { headers: this.postHeaders });
  }

}
