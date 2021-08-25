import { Component, OnInit } from '@angular/core';
import { Deck } from 'src/app/models/deck';
import { HttpDeckService } from 'src/app/services/http-deck.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Card } from 'src/app/models/card';

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

  //this array should be populated by the deck that is selected
  dynamicArray: Card[]= [
    //{ "id": 0, "question": "This is question 1", "answer": "This is answer 1", "createdOn": 0 },
   //{ "id": 1, "question": "This is question 2", "answer": "This is answer 2", "createdOn": 0 },
   // { "id": 2, "question": "This is question 3", "answer": "This is answer 3", "createdOn": 0 }
  ]; 
  newDynamic: any;
  ngOnInit(): void {  
      //this.newDynamic = {'id': 0, 'question':'', 'answer':'', 'createdOn':0};
      //this.newDynamic = this.card;
      //this.dynamicArray.push(this.newDynamic); 
      this.displayAllDecks(); 
      this.curUser = localStorage.getItem("username");
      console.log(this.curUser);
  } 


closeResult = '';

constructor(private modalService: NgbModal, private deckHttp: HttpDeckService) {}


addRow() {    
  //this.newDynamic = {};
  this.newDynamic = {'id': 0, 'question':'', 'answer':'', 'createdOn':0};
  //this.card.id = this.curDeck.cards.length++;
  //this.newDynamic = this.card;
  this.dynamicArray.push(this.newDynamic);    
  console.log(this.dynamicArray);  
  return true;  
}  

deleteRow(index: any) {  
  if(this.dynamicArray.length ==1) {    
      return false;  
  } else {  
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
  //okay I will not be doing the update deck and cards. Instead I will be adding the cards and deleting the cards in a loop
  //since the update deck and cards doesn't work with updating the card list.
  for (let i = 0; i < this.curDeck.cards.length; i++) {
    //i need an added cards list and a deleted cards list
    //for the deleted cards list, when I click on the trash can the id should be saved somewhere in a list or array, then I can just loop through those ID's and 
    //delete each one
    //for the added cards list I can just take the items which don't have ID's and put them in a list or an array, and then add them to the corresponding
    //deck in the loop.
  }

}
}
