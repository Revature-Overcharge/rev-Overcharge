import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-objectives',
  templateUrl: './objectives.component.html',
  styleUrls: ['./objectives.component.css']
})
export class ObjectivesComponent implements OnInit {

  count: number = 0;
  value: number;
  progressBar: string = "progress-bar progress-bar-striped progress-bar-animated";

  constructor() { }

  ngOnInit(): void {
    if (this.value == 100){
      this.progressBar = "progress-bar";
    }
  }

  checkValue(){
    this.progressBar = "progress-bar progress-bar-striped progress-bar-animated";
    this.count++
    switch(this.count){
      case 1:
        this.value = 25;
        break;
      case 2:
        this.value = 50;
        break;
      case 3: 
        this.value = 75;
        break;
      case 4:
        this.value = 100;
        this.progressBar = "progress-bar";
        break;
      case 5:
        this.count = 0;
        this.value = 0;
    }

  }
}
