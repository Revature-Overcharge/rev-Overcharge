import { Deck } from 'src/app/models/deck';
export class Tag{
    id: number;
    tag: string;
    decks: Array<Deck>;
}