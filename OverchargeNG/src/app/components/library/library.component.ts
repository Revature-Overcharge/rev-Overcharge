import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Card } from 'src/app/models/card'; 

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {

  //TODO Sean, your merge conflict didn't resolve. 
  //    This is the new code:
  
  // constructor(private deckHttp: HttpDeckService) { }

  // ngOnInit(): void {
  //   this.displayAllDecks();
  // }

  // deckList: Deck[] = [];

  // displayAllDecks() {
  //   this.deckHttp.getAllDecks().subscribe(
  //     (response) => {
  //       console.log(response);
  //       this.deckList = response;
  //     }
  //   );
  //   console.log(this.deckList);
  // }


  card: Card = new Card(0, "", "", 0);

  dynamicArray: Array<Card> = [
    { "id": 0, "question": "This is question 1", "answer": "This is answer 1", "createdOn": 0 },
    { "id": 1, "question": "This is question 2", "answer": "This is answer 2", "createdOn": 0 },
    { "id": 2, "question": "This is question 3", "answer": "This is answer 3", "createdOn": 0 }
  ]; 
  newDynamic: any = {};  
  ngOnInit(): void {  
      this.newDynamic = {title1: "", title2: ""};  
      this.dynamicArray.push(this.newDynamic);  
  } 


closeResult = '';

constructor(private modalService: NgbModal) {}


addRow() {    
  this.newDynamic = {title1: "", title2: ""};  
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

open(content: any, card: Card, size: any) {
  this.card = card;

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
}
