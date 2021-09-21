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
    console.log("getAllDecks()");
    return this.http.get<Deck[]> ('http://localhost:8081/decks');
  }

  getDeckById(id: number): Observable<Deck> {
    console.log("getDeckById(" + id + ")");
    return this.http.get<Deck> ('http://localhost:8081/decks/' + id);
  }

  getDeckByTagId(id: number): Observable<Deck[]> { 
    return this.http.get<Deck[]>(`http://localhost:8081/decksByTag?tagId=${id}`);
  }

  getDeckByTitle(title: string): Observable<Deck> {
    console.log("getDeckByTitle()");
    return this.http.get<Deck> ('http://localhost:8081/decks/title?' + title);
  }

  addDeck(deck: any): Observable<Deck> {
    console.log("addDeck()");
    return this.http.post<Deck>('http://localhost:8081/decks/', deck, { headers: this.postHeaders });
  }

  updateDeck(deck: Deck): Observable<Deck> {
    console.log("updateDeck()");
    return this.http.put<Deck>('http://localhost:8081/decks/' + deck.id, deck, { headers: this.postHeaders });
  }

  updateDeckAndCards(deck: Deck): Observable<Deck> {
    console.log("updateDeckAndCards()");
    return this.http.put<Deck>('http://localhost:8081/decks/' + deck.id + '/cards', deck, { headers: this.postHeaders });
  }

  deleteDeck(id: number): Observable<boolean>{
    console.log("deleteDeck()");
    return this.http.delete<boolean>('http://localhost:8081/decks/' + id);
  }
  setDeckTags(id:number, tags:Number[]): Observable<Deck>{
    return this.http.put<Deck>(`http://localhost:8081/setDeckTags/${id}`, {
      'tagsId': tags
  
  }, { headers: this.postHeaders });
  }

  getDeckByTagId(id: number): Observable<Deck[]> {
    return this.http.get<Deck[]>(`http://localhost:8081/decksByTag?tagId=${id}`);
  }

}


