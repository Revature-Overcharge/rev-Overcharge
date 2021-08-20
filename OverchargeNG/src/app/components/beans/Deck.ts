export class Deck {
    
    id: number;
    creator: User;
    title: string;
    created_on: number;

   constructor(id: number, creator: User, title: string, created_on: number){
     this.id = id;
     this.creator = creator;
     this.title = title; 
     this.created_on = created_on; 
  }
}
