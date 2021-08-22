import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class StudiedcardService {
  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http : HttpClient) { }

  addStudiedCard(card: StudiedCard) :Observable<StudiedCard>{
    return this.http.post<StudiedCard>('http://localhost:8080/studied_cards',card, { headers: this.postHeaders });
  }

  getStudiedCardsByUser(user_id: number):Observable<StudiedCard[]>{
    return this.http.get<StudiedCard[]>('http://localhost:8080/studied');

  }

  deleteStudiedCard(studied_card_id: number):Observable<StudiedCard>{
    return this.http.delete<StudiedCard>('http://localhost:8080/studied_cards');

  }

}
