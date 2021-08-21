import { User } from "./User";

export class Deck {
    
    id: number;
    creator: User;
    title: string;
    createdOn: number;

   constructor(id: number, creator: User, title: string, createdOn: number){
     this.id = id;
     this.creator = creator;
     this.title = title; 
     this.createdOn = createdOn; 
  }
}
