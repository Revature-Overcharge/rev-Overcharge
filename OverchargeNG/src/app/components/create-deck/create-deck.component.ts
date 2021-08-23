import { Component, OnInit } from '@angular/core';
import { Card } from 'src/app/models/card';
import { Deck } from 'src/app/models/deck';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { HttpDeckService } from 'src/app/services/http-deck.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-create-deck',
  templateUrl: './create-deck.component.html',
  styleUrls: ['./create-deck.component.css']
})
export class CreateDeckComponent implements OnInit {

  constructor(private modalService: NgbModal, private deckHttp: HttpDeckService) { }

  ngOnInit(): void {  
      this.newDynamic = {title1: "", title2: ""};  
      this.dynamicArray.push(this.newDynamic);
  }

  title = '';

  closeResult = '';
  card: Card = new Card(0, "", "", 0);
  newDynamic: any = {};  
  dynamicArray: Array<Card> = []; 
  deck: Deck = new Deck(0, new User("mclapston0","kGex8fqXt8", 1, 89, 1629315831000),this.title, 0, []);

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

  createDeck() {
    this.deckHttp.addDeck(this.deck).subscribe(
      (response) => {
        console.log(response);
      }
    )
  }

}
