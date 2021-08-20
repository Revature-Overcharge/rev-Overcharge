export class flashcardset {
  setid: number;
  name: string;
  category: string;
 

 
   constructor(setid: number, category: string, name: string){
     this.setid = setid;
     this.name = name;
     this.category  = category;
     
   }
 }