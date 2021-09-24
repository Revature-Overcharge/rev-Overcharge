import { Component, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { StudiedCard } from 'src/app/models/studied-card';
import { StudiedcardService } from 'src/app/services/studiedcard.service';
import { CardService } from 'src/app/services/card.service';
import { Card } from 'src/app/models/card';
import { Rating } from 'src/app/models/rating';
import { RatingService } from 'src/app/services/rating.service';
import { Router } from '@angular/router';
import { HttpDeckService } from 'src/app/services/http-deck.service';
import { Feedback } from '../../models/feedback';
import { FeedbackService } from '../../services/feedback.service';
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
  constructor(private schttp:StudiedcardService, private cshttp:CardService, private rshttp: RatingService,private dshttp:HttpDeckService, private router:Router, private fbhttp: FeedbackService) { }
  
  Cards: Card[] = [];
  Feedbacks: Feedback[] = [];
  CurrentCard: Card = new Card(1,'','',1);
  rating:Rating = new Rating(0,0,0,0);
  deck_id:number = 2;
  text:string = '';
  creator_id:number=0;
  user_id:number = 0;
  number_mastered = 0;
  number_total = 0;
  count = 0;

  //new declarations
  feedback: Feedback = new Feedback('');
  fbContent: string = '';
  //end of new declarations

  public crnt: number = 0;

  public next: String = 'Next Question';
  public unfinished: boolean = true;
  public rate: boolean =false;
  public finished:boolean = false;
  public array:StudiedCard[] = [];
  public feedbackContent:String = '';
  public question:string = '';
  public answer:string = '';


  ngOnInit(): void {
    this.user_id = Number(window.localStorage.getItem("userID"));
    this.deck_id = Number(window.localStorage.getItem("deckID"));

    console.log("this.deck_id: ["+this.deck_id+"]");
    this.dshttp.getDeckById(this.deck_id).subscribe(
      (Response1)=>{
        this.creator_id = Response1.creator.id;
        this.Cards= Response1.cards;
        this.question = this.Cards[this.crnt].question;
        this.answer = this.Cards[this.crnt].answer;
        this.CurrentCard = this.Cards[this.crnt];
        this.number_total = this.Cards.length;
        this.Feedbacks = Response1.feedback;
        this.schttp.getStudiedCardsByUser(this.user_id).subscribe(
          (Response2)=>{
            this.array = Response2;
            console.log(this.Feedbacks);

        let index:number = 0;
        console.log("Length before filtering : " + this.Cards.length)
        for(let card of this.Cards){

          for(let i:number =0;i<this.array.length;i++){


           if(card.id === this.array[i].cardId){
             this.count++;
             console.log("deletion should occur");
             delete this.Cards[index];
           }
          }
        index++;
        }
        const filteredCards = this.Cards.filter(el => {
          return el != null;
        });
        this.number_mastered = this.count;
        this.Cards = filteredCards;
        console.log("Length after filtering : " + this.Cards.length)
        

        
          }
        )
      }
      )


  }

  public preprogress: number = 1/this.Cards.length*100;
  public progress:string = this.preprogress + '%';  


  studied_card:StudiedCard = new StudiedCard(1,2,2);

  flip: string = 'inactive';

  toggleFlip() {
    this.flip = (this.flip == 'inactive') ? 'active' : 'inactive';
  }

  nextQuestion(){
    var count = this.Cards.length;

    if(this.crnt != (count - 1)){
      if(this.flip == 'active'){
        this.flip = 'inactive';
      }

      this.question = this.Cards[this.crnt + 1].question;
      this.answer = this.Cards[this.crnt + 1].answer;
      this.CurrentCard = this.Cards[this.crnt + 1];
      this.text = '';

      this.crnt = this.crnt + 1;
      this.preprogress = Math.round((this.crnt+1)/this.Cards.length*100);
      this.progress =  String(this.preprogress) + "%";

      
      if(this.crnt== this.Cards.length -1){
        this.next = 'Finish Set';
      }
      else{this.next = 'Next Question';}

    }
    else{
      this.unfinished = false;

      if(this.creator_id ==this.user_id){this.finished = true;}
      else{this.rate = true;}
    }

  }

  prevQuestion(){
    if(this.flip == 'active'){
      this.flip = 'inactive';
    }
    if(this.crnt != 0){
      this.question = this.Cards[this.crnt - 1].question;
      this.answer = this.Cards[this.crnt - 1].answer;
      this.CurrentCard = this.Cards[this.crnt - 1];

      this.text = '';
      this.crnt = this.crnt - 1;
      this.preprogress = Math.round((this.crnt+1)/this.Cards.length*100);
      this.progress =  String(this.preprogress) + "%";
      if(this.crnt== this.Cards.length -1){
        this.next = 'Finish Set';
      }
      else{this.next = 'Next Question';}
    }


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
    let userid: number = 0;
    userid = Number(window.localStorage.getItem("userID"));
    console.log("userID taken from storage : " + userid);
    this.rating.userId = userid;
    this.rating.deckId = this.deck_id;
    this.rating.stars = this.userRating;

    console.log("Rating sent to be aded : " + JSON.stringify(this.rating));


    this.rshttp.addRating(this.rating).subscribe(
      (Response)=>{
        console.log("Rating response : " + JSON.stringify(Response));
      }
    )
    
    // Feedback Submission 
    this.feedback.createdOn = new Date().getDate();
    this.feedback.content = this.fbContent;

    if (this.fbContent !== '') {
      this.fbhttp.addFeedbacks(this.deck_id, this.feedback).subscribe(
        (response)=> {
          console.log("Feedback added: " + JSON.stringify(response));
        }
      )
    }

    this.router.navigate(['/','library']);
  }

  
  markAsMastered(){

    let userid: number = 0;
    userid = Number(window.localStorage.getItem("userID"));

    this.studied_card.cardId = this.CurrentCard.id;
    this.studied_card.userId = userid;

    this.schttp.addStudiedCard(this.studied_card).subscribe(
      (Response)=>{
        console.log("Response from adding studied card : " + JSON.stringify(Response));
      }
    )


    //go to next card and update progress bar 

    var count = Object.keys(this.Cards).length;

    if(this.crnt != (count - 1)){
      if(this.flip == 'active'){
        this.flip = 'inactive';
      }
      this.question = this.Cards[this.crnt + 1].question;
      this.answer = this.Cards[this.crnt + 1].answer;
      this.CurrentCard = this.Cards[this.crnt + 1];
      this.text = '';

      this.crnt = this.crnt + 1;
      this.preprogress = Math.round((this.crnt+1)/this.Cards.length*100);
      this.progress =  String(this.preprogress) + "%";
      
      
      if(this.crnt== this.Cards.length -1){
        this.next = 'Finish Set';
      }
      else{this.next = 'Next Question';}

    }
    else{
      this.unfinished = false;
      this.rate = true; 
    }
  }

returnToLibrary(){
  this.router.navigate(['/','library']);
}
}