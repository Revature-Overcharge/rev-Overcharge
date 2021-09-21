import { User } from 'src/app/models/user';
import { Card } from './card';
import { Tag } from './tag';

export class Deck {
  id: number;
  creator: User;
  title: string;
  createdOn: number;
  cards: Array<Card>;
  tags: Array<Tag>;
  avgRating: any;

  constructor(
    id: number,
    creator: User,
    title: string,
    createdOn: number,
    cards: Array<Card>,
    avgRating?: number
  ) {
    this.id = id;
    this.creator = creator;
    this.title = title;
    this.createdOn = createdOn;
    this.cards = cards;
    this.avgRating = avgRating;
  }
}
