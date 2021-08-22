import { Component, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';

@Component({
  selector: 'app-cardrunner',
  templateUrl: './card-runner.component.html',
  styleUrls: ['./card-runner.component.css'],
  animations: [
    trigger('flipState', [
      state('active', style({
        transform: 'rotateY(179deg)'
      })),
      state('inactive', style({
        transform: 'rotateY(0)'
      })),
      transition('active => inactive', animate('500ms ease-out')),
      transition('inactive => active', animate('500ms ease-in'))
    ])
  ]
})
export class CardrunnerComponent implements OnInit {

  

  public crnt: number = 0;
  testCards: Array<any> = [
    {'question': 'question1', 'answer': 'answer1'},
    {'question': 'question2', 'answer': 'answer2'},
    {'question': 'question3', 'answer': 'answer3'}
  ]
  public next: String = 'Next Question';
  public unfinished: boolean = true;
  public rate: boolean =false;
  public preprogress: number = 1/this.testCards.length*100;
  public progress:string = this.preprogress + '%';  

  public question:string = this.testCards[this.crnt].question;
  public answer:string = this.testCards[this.crnt].answer;



  constructor() { }

  ngOnInit(): void {
  }

  flip: string = 'inactive';

  toggleFlip() {
    this.flip = (this.flip == 'inactive') ? 'active' : 'inactive';
  }

  nextQuestion(){
    var count = Object.keys(this.testCards).length;

    if(this.crnt != (count - 1)){
      if(this.flip == 'active'){
        this.flip = 'inactive';
      }
      this.question = this.testCards[this.crnt + 1].question;
      this.answer = this.testCards[this.crnt + 1].answer;
      this.crnt = this.crnt + 1;
      this.preprogress = Math.round((this.crnt+1)/this.testCards.length*100);
      this.progress =  String(this.preprogress) + "%";
      
      if(this.crnt== this.testCards.length -1){
        this.next = 'Finish Set';
      }
      else{this.next = 'Next Question';}

    }
    else{
      this.unfinished = false;
      this.rate = true;
    }

  }

  prevQuestion(){
    if(this.flip == 'active'){
      this.flip = 'inactive';
    }
    if(this.crnt != 0){
      this.question = this.testCards[this.crnt - 1].question;
      this.answer = this.testCards[this.crnt - 1].answer;
      this.crnt = this.crnt - 1;
      this.preprogress = Math.round((this.crnt+1)/this.testCards.length*100);
      this.progress =  String(this.preprogress) + "%";
      if(this.crnt== this.testCards.length -1){
        this.next = 'Finish Set';
      }
      else{this.next = 'Next Question';}
    }


  }

  markMastered(){
    alert("AUUUGGHHHHHHH!!!");
  }


  
  userRating:number = 0;
  class:string = 'fa fa-star unchecked';
  class2:string = 'fa fa-star unchecked';
  class3:string = 'fa fa-star unchecked';
  class4:string = 'fa fa-star unchecked';
  class5:string = 'fa fa-star unchecked';

  ratingStars(stars:number){
  switch (stars) {
    case 1:
      this.class = 'fa fa-star checked';
      this.class2= 'fa fa-star unchecked';
      this.class3= 'fa fa-star unchecked';
      this.class4= 'fa fa-star unchecked';
      this.class5 = 'fa fa-star unchecked';
      this.userRating = 1;
        break;
    case 2:
      this.class = 'fa fa-star checked';
      this.class2= 'fa fa-star checked';
      this.class3= 'fa fa-star unchecked';
      this.class4= 'fa fa-star unchecked';
      this.class5 = 'fa fa-star unchecked';
      this.userRating = 2;
  
        break;
    case 3:
      this.class = 'fa fa-star checked';
      this.class2= 'fa fa-star checked';
      this.class3= 'fa fa-star checked';
      this.class4= 'fa fa-star unchecked';
      this.class5 = 'fa fa-star unchecked';
      this.userRating = 3;
          break;
    case 4:
      this.class = 'fa fa-star checked';
      this.class2= 'fa fa-star checked';
      this.class3= 'fa fa-star checked';
      this.class4= 'fa fa-star checked';
      this.class5 = 'fa fa-star unchecked';
      this.userRating = 4;
          break;

    case 5:
      this.class = 'fa fa-star checked';
      this.class2= 'fa fa-star checked';
      this.class3= 'fa fa-star checked';
      this.class4= 'fa fa-star checked';
      this.class5 = 'fa fa-star checked';
      this.userRating = 5;
            break;
      
      }}
 
  submitRating(){

  }

  markAsMastered(){
    //Create new studied card
  }
}
