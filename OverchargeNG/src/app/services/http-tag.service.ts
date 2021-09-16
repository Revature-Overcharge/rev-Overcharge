import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tag } from '../models/tag';

@Injectable({
  providedIn: 'root'
})
export class HttpTagService {

  constructor(private http: HttpClient) { }

  getAllTags(): Observable<Tag[]> {
    return this.http.get<Tag[]>('http://localhost:8081/tags');
  }
}
