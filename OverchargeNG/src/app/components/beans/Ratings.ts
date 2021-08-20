export class Ratings {

    user_id: number;
    deck_id: number;
    stars: number;
    rated_on: number;

    constructor(user_id: number, deck_id: number, stars: number, rated_on: number) {
        this.user_id = user_id;
        this.deck_id = deck_id;
        this.stars = stars;
        this.rated_on = rated_on;
    }
}