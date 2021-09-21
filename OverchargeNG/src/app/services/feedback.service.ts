import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Feedback } from '../models/feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private http: HttpClient) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getFeedbacksByDeckId(id: number): Observable<Feedback[]>{
    return this.http.get<Feedback[]>('http://localhost:8081/decks/' + id + '/feedbacks');
  }

  addFeedbacks(id: number, feedback: Feedback): Observable<Feedback>{
    return this.http.post<Feedback>('http://localhost:8081/decks/' + id + '/feedbacks', feedback, { headers: this.postHeaders});
  }

  deleteFeebacks(id: number): Observable<boolean>{
    return this.http.delete<boolean>('http://localhost:8081/feedbacks/' + id);
  }
}
