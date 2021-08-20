import { Component, OnInit } from '@angular/core';
import { Deck } from 'src/app/models/Deck';
import { HttpDeckService } from 'src/app/services/http-deck.service';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {

  constructor(private deckHttp: HttpDeckService) { }

  ngOnInit(): void {
    this.displayAllDecks();
  }

  deckList: Deck[] = [];

  displayAllDecks() {
    this.deckHttp.getAllDecks().subscribe(
      (response) => {
        console.log(response);
        this.deckList = response;
      }
    );
    console.log(this.deckList);
  }

}
