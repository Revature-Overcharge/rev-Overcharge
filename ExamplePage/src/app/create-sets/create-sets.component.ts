import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-sets',
  templateUrl: './create-sets.component.html',
  styleUrls: ['./create-sets.component.css']
})
export class CreateSetsComponent implements OnInit {

  addsMore:string = "";
  save:string = '';

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  showText(){
    this.addsMore = "Function to add more of these...";
  }

  fakeSuccess(){
    this.save = "Successfull Save! (not really...)"
  }
}
