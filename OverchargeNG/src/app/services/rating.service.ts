import { Injectable } from '@angular/core';
import { Rating } from '../models/rating';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class RatingService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http:HttpClient) { }

  addRating(rating: Rating) : Observable<Rating>{
    return this.http.post<Rating>(`http://localhost:8080/ratings`, rating, {responseType: "json", headers: this.headers} );

  }
 
  getRatings(): Observable<Rating[]>{
    return this.http.get<Rating[]>(`http://localhost:8080/ratings`);

  }

  getRatingsByIds(user_id:number,deck_id:number): Observable<Rating[]>{
    return this.http.get<Rating[]>(`http://localhost:8080/ratings?userId=` + user_id+ '&deckId=' + deck_id);

  }
}
