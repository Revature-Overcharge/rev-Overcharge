export class StudiedCard {
    userId: number;
    cardId: number;
    finished_on: number;

   
  
   
     constructor(user_id: number, card_id: number, finished_on: number) {
       this.userId = user_id;
       this.cardId = card_id;

       this.finished_on = finished_on;
     }
   }
