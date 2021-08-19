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

  public progress:number = 85;
  public progress2:string = this.progress + "%";
  public crnt = 0;

  testCards: Array<any> = [
    {'question': 'question1', 'answer': 'answer1'},
    {'question': 'question2', 'answer': 'answer2'},
    {'question': 'question3', 'answer': 'answer3'}
  ]

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
    }
  }

  markMastered(){
    alert("Marked mastered");
  }

}
