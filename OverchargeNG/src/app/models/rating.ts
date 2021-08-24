export class Rating {
    userId: number;
    deckId: number;
    stars: number;
    ratedOn: number;

   
  
   
     constructor(user_id: number,deck_id:number, stars: number, rated_on: number){
       this.userId = user_id;
       this.deckId = deck_id;
       this.stars = stars;
       this.ratedOn = rated_on;
     }
   }
