import { User } from 'src/app/models/user';
import { Card } from './card';
import { Feedback } from './feedback';

export class Deck {
  id: number;
  creator: User;
  title: string;
  createdOn: number;
  cards: Array<Card>;
  avgRating: any;
  feedbacks: Array<Feedback>;

  constructor(
    id: number,
    creator: User,
    title: string,
    createdOn: number,
    cards: Array<Card>,
    avgRating?: number,
    feedbacks?: Array<Feedback>
  ) {
    this.id = id;
    this.creator = creator;
    this.title = title;
    this.createdOn = createdOn;
    this.cards = cards;
    this.avgRating = avgRating;
    //this.feedbacks = feedbacks;
  }
}
