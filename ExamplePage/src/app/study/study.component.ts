import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-study',
  templateUrl: './study.component.html',
  styleUrls: ['./study.component.css']
})
export class StudyComponent implements OnInit {

  card: string = '';

  constructor() { }

  ngOnInit(): void {
  }

  nextCard(){
    this.card = "Function for another card or flip this card...";
  }
}
