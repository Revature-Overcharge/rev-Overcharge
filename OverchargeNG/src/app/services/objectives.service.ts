import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})

export class ObjectivesService {

  constructor( private http: HttpClient) { }

  count: number = 0;
  value: number;
  value1:number = 50;
  progressBar: string = "progress-bar progress-bar-striped progress-bar-animated";

  loginObj = {name:"Login", pointsToAward: "10", progressCount:"0", countForGoal:"1"};
  dailyObj2 = this.randomDailyObj();
  dailyObj3 = this.randomDailyObj();
  weeklyObj = this.randomWeeklyObj();
  weeklyObj2 = this.randomWeeklyObj();
  weeklyObj3 = this.randomWeeklyObj();


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

  randomDailyObj(){
    let dailyObj = [
    {name:"Rank a Set", pointsToAward: "10", progressCount:"1", countForGoal:"1"},
    {name:"Create 5 Sets", pointsToAward: "150", progressCount:"0", countForGoal:"5"},
    {name:"Create 3 Cards", pointsToAward: "50", progressCount:"0", countForGoal:"3"},
    {name:"Create 5 Cards", pointsToAward: "150", progressCount:"0", countForGoal:"5"},
    {name:"Create 10 Cards", pointsToAward: "100", progressCount:"0", countForGoal:"10"}
  ]
  let myDailyList = dailyObj[Math.floor(Math.random() * 5)]

    return myDailyList;
  }

  randomWeeklyObj(){
    let weeklyObj = [
    {name:"Create a Set", pointsToAward: "300", progressCount:"0", countForGoal:"1"},
    {name:"Master 50 Cards", pointsToAward: "50", progressCount:"0", countForGoal:"50"},
    {name:"Create 25 Sets", pointsToAward: "250", progressCount:"0", countForGoal:"25"},
    {name:"Create 25 Cards", pointsToAward: "100", progressCount:"0", countForGoal:"25"},
    {name:"Create 50 Cards", pointsToAward: "250", progressCount:"0", countForGoal:"50"}
  ]
  let myWeeklyList = weeklyObj[Math.floor(Math.random() * 5)]

    return myWeeklyList;
  }

  checkValue(){
    this.progressBar = "progress-bar progress-bar-striped progress-bar-animated";
    this.count++

    switch(this.count){
      case 1:
        this.value = 100;
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

  getObjectives(){
    return this.http.get<User>('http://localhost:8080/users/' + localStorage.getItem("userID") + '/objectives');
  }
}
