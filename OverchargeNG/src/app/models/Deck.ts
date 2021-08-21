import { User } from "src/app/models/user";

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

//TODO Suart's team
//Why are the fields different?
// export class flashcardset {
//   setid: number;
//   name: string;
//   category: string;
  
//   constructor(setid: number, category: string, name: string){
//     this.setid = setid;
//     this.name = name;
//     this.category  = category;
     
//   }
// }
