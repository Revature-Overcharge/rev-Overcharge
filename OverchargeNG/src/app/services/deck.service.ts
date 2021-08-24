import { Injectable } from '@angular/core';
import { Deck } from '../models/deck';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class DeckService {

  constructor() { }

  deck: Deck = new Deck(0, new User('', '', 0, 0, 0), '', 0);
}
