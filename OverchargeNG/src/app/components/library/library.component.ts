import { Component, OnInit } from '@angular/core';
import { Deck } from 'src/app/models/deck';
import { HttpDeckService } from 'src/app/services/http-deck.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Card } from 'src/app/models/card';
import { CardService } from 'src/app/services/card.service';

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

  //this array should be populated by the deck that is selected
  dynamicArray: Card[]= []; 
  newDynamic: any;
  ngOnInit(): void {   
      this.displayAllDecks(); 
      this.curUser = localStorage.getItem("username");
      console.log(this.curUser);
  } 


closeResult = '';

constructor(private modalService: NgbModal, private deckHttp: HttpDeckService, private cardService: CardService) {}


addRow() {    
  this.newDynamic = {'id': 0, 'question':'', 'answer':'', 'createdOn':0};
  this.dynamicArray.push(this.newDynamic);    
  console.log(this.dynamicArray);  
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
}
