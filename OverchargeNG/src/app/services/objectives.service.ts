import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class ObjectivesService {

  constructor() { }

  count: number = 0;
  value: number;
  progressBar: string = "progress-bar progress-bar-striped progress-bar-animated";

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

  getValue(){
    return this.value;
  }

  getProgressBar(){
    return this.progressBar;
  }

  checkComplete(){
    if (this.value == 100){
      this.progressBar = "progress-bar";
    }
  }
}
