import { Component, OnInit } from '@angular/core';
import { Deck } from 'src/app/models/deck';
import { Tag } from 'src/app/models/tag';
import { HttpDeckService } from 'src/app/services/http-deck.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Card } from 'src/app/models/card';
import { CardService } from 'src/app/services/card.service';
import { FeedbackService } from '../../services/feedback.service';
import { Feedback } from '../../models/feedback';
import { HttpErrorResponse } from '@angular/common/http';
import { HttpTagService } from 'src/app/services/http-tag.service';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {


  //the deck list shall be populated from all of the decks in the database
  deckList: Deck[] = [];
  card: Card = new Card(0, "", "", 0);
  curUser: any;
  curDeck: Deck;
  addedCards: Card[] = [];
  deletedCards: number[] = [];

  //For Feedback
  feedbackList: Feedback[] = [];
  displayFeedback: boolean = false;
  deckTitle: string = '';

  //For errors
  showfeedbackErrorMessage: boolean = false;
  feedbackErrorMessage: string = '';

  tags: Tag[] =[];
  filterChoice: number = 0;

  //this array should be populated by the deck that is selected
  dynamicArray: Card[]= [];
  newDynamic: any;
  ngOnInit(): void {
      this.displayAllDecks();
      this.getAllTags();
      this.curUser = localStorage.getItem("username");
  }


closeResult = '';

constructor(private tagHttp: HttpTagService, private modalService: NgbModal, private deckHttp: HttpDeckService, private cardService: CardService, private fbhttp: FeedbackService) {}

addRow() {
  this.newDynamic = {'id': 0, 'question':'', 'answer':'', 'createdOn':0};
  this.dynamicArray.push(this.newDynamic);
  return true;
}


deleteRow(index: any) {
  if(this.dynamicArray.length ==1) {
      return false;
  } else {
    if(this.dynamicArray[index].id != 0) {
      this.deletedCards.push(this.dynamicArray[index].id);
    }
      this.dynamicArray.splice(index, 1);
      return true;
  }
}
getAllTags(){
  this.tagHttp.getAllTags().subscribe((data) =>{
    this.tags = data;
  })
}
getFilteredList(){
  this.deckHttp.getDeckByTagId(this.filterChoice).subscribe((data) =>{
    this.deckList = data;

  })
}

  displayAllDecks() {
    this.deckHttp.getAllDecks().subscribe(
      (response) => {
        console.log(response);
        this.deckList = response;
      }
    );
    console.log(this.deckList);
  }

open(content: any, card: Card, size: any, deck: Deck) {
  this.card = card;
  //Added a cards array to the deck object so I can grab it to display here
  this.dynamicArray = deck.cards;
  this.curDeck = deck;
  //clear the deleted cards array when you open up the modal
  this.deletedCards = [];

	this.modalService.open(content,
{ariaLabelledBy: 'modal-basic-title', size: size}).result.then((result) => {
	this.closeResult = `Closed with: ${result}`;
	}, (reason) => {
	this.closeResult =
		`Dismissed ${this.getDismissReason(reason)}`;
	});
}

private getDismissReason(reason: any): string {
	if (reason === ModalDismissReasons.ESC) {
	return 'by pressing ESC';
	} else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
	return 'by clicking on a backdrop';
	} else {
	return `with: ${reason}`;
	}
}

saveDeck(deckArray: Array<Card>) {
  this.addedCards = [];
  for (let i = 0; i < this.curDeck.cards.length; i++) {
    if(this.curDeck.cards[i].id == 0 && this.curDeck.cards[i].question != "") {
      this.addedCards.push(this.curDeck.cards[i]);
    }
  }
  for(let i = 0; i < this.addedCards.length; i++){
    let newCard = new Card(0, this.addedCards[i].question, this.addedCards[i].answer, 0);
    this.cardService.addCard(this.curDeck.id, newCard).subscribe();
  }
  for(let i = 0; i < this.deletedCards.length; i++) {
    this.cardService.deleteCard(this.deletedCards[i]).subscribe();
  }
}

getDeckId(id: number) {
  //save the deck id to local storage
  window.localStorage.setItem("deckID", id.toString());
}

//Feedback Functions

openFeedback(deckID: number, deckName: string) {
  this.showfeedbackErrorMessage = false;
  this.deckTitle = deckName;
  this.fbhttp.getFeedbacksByDeckId(deckID).subscribe((response) => {
      this.feedbackList = response;
  },
  (err: HttpErrorResponse) => {
    this.showfeedbackErrorMessage = true;
    this.feedbackErrorMessage = "There is currently no feedback available";
  });

  this.displayFeedback = !this.displayFeedback;

}
}
