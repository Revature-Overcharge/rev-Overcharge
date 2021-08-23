export class Card {

    id: number;
    question: string;
    answer: string;
    createdOn: number;
  
    constructor(id: number, question: string, answer: string, createdOn: number){
      this.id = id;
      this.question = question;
      this.answer = answer;
      this.createdOn = createdOn;
    }
}
