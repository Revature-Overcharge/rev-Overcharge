import { Component, OnInit } from '@angular/core';
import { Card } from 'src/app/models/card';
import { Deck } from 'src/app/models/deck';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { HttpDeckService } from 'src/app/services/http-deck.service';
import { HttpUserService } from 'src/app/services/http-user.service';
import { User } from 'src/app/models/user';
import { Tag } from 'src/app/models/tag';
import { HttpTagService } from 'src/app/services/http-tag.service';

@Component({
  selector: 'app-create-deck',
  templateUrl: './create-deck.component.html',
  styleUrls: ['./create-deck.component.css']
})
export class CreateDeckComponent implements OnInit {

  constructor(private tagHttp: HttpTagService,private modalService: NgbModal, private deckHttp: HttpDeckService, private userHttp: HttpUserService) { }

  ngOnInit(): void {  
      //this.newDynamic = {title1: "", title2: ""};  
      //this.dynamicArrayCard.push(this.newDynamic);
      this.getUser();
      this.getAllTags(); 
  }

  title = '';

  deckMessage: boolean;
  closeResult = '';
  card: Card = new Card(0, "", "", 0);
  newDynamic: any = {};  
  dynamicArrayCard: Array<Card> = [];
  dynamicArrayTag: Array<Number> = [];  
  user: User;
  deck: Deck;
  tags: Tag[] =[];
  tagIds: Number[] = [];
  cards: Card[] = [];

  getAllTags(){
    this.tagHttp.getAllTags().subscribe((data) =>{
      this.tags = data;
    })
  }

  addRowCard() {    
    this.newDynamic = {};  
    this.dynamicArrayCard.push(this.newDynamic);    
    console.log(this.dynamicArrayCard);  
    return true;  
  }
  addRowTag() {    
    this.newDynamic = {};  
    this.dynamicArrayTag.push(this.newDynamic);    
    console.log(this.dynamicArrayTag);  
    return true;  
  }    
  
  deleteRowCard(index: any) {  
    if(this.dynamicArrayCard.length ==1) {    
        return false;  
    } else {  
        this.dynamicArrayCard.splice(index, 1);    
        return true;  
    }  
  }
  deleteRowTag(index: any) {  
    if(this.dynamicArrayTag.length ==1) {    
        return false;  
    } else {  
        this.dynamicArrayTag.splice(index, 1);    
        return true;  
    }  
  }


  openCards(content: any, card: Card, size: any) {
    this.card = card;
  
    this.modalService.open(content,
    {ariaLabelledBy: 'modal-basic-title', size: size}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
    this.closeResult =
      `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  openTags(content: any, size: any) {
  
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
    this.getUser();
    console.log(this.user);
    if(this.title == ''){
      alert("Please give your deck a title");
    }
    else if(this.user == null){
      alert("Please log in before creating a deck");
    } 
    else {
      this.deckMessage = true;
      this.deck.title = this.title;
      for(let i = 0; i < this.dynamicArrayTag.length-1; i++){
        this.tagIds.push(this.dynamicArrayTag[i]);

      }
      for(let i = 0; i < this.dynamicArrayCard.length-1; i++){
        this.cards.push(this.dynamicArrayCard[i]);

      }
      this.deck.cards = this.cards;
      console.log("tag ids to be added:" + this.tagIds);
      this.deckHttp.addDeck(this.deck).subscribe(
        (response) => {
          this.deckHttp.setDeckTags(response.id, this.tagIds).subscribe((data) => {
            console.log("here");

          })
        }
      )
    }
  }

  getUser(){
    this.userHttp.getUserById(Number(localStorage.getItem("userID"))).subscribe(
      (response) => {
        this.user = response;
        this.deck = new Deck(0, this.user,this.title, 0, this.dynamicArrayCard);
      }
    )
  }

}
