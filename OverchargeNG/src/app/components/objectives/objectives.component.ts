import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { LoginService } from 'src/app/services/login.service';
import { ObjectivesService } from 'src/app/services/objectives.service';

@Component({
  selector: 'app-objectives',
  templateUrl: './objectives.component.html',
  styleUrls: ['./objectives.component.css']
})
export class ObjectivesComponent implements OnInit {

  userPointCount: number;
  value: number;
  value1:number;
  progressBar: string = "progress-bar progress-bar-striped progress-bar-animated";

  dailyObj = this.objData.loginObj;
  nameObj = this.dailyObj.name;
  pointsObj = this.dailyObj.pointsToAward;

  nameObj2 = this.objData.dailyObj2.name;
  pointsObj2 = this.objData.dailyObj2.pointsToAward;

  nameObj3 = this.objData.dailyObj3.name;
  pointsObj3 = this.objData.dailyObj3.pointsToAward;

  nameObj4 = this.objData.weeklyObj.name;
  pointsObj4 = this.objData.weeklyObj.pointsToAward;

  nameObj5 = this.objData.weeklyObj2.name;
  pointsObj5 = this.objData.weeklyObj2.pointsToAward;

  nameObj6 = this.objData.weeklyObj3.name;
  pointsObj6 = this.objData.weeklyObj3.pointsToAward;

  objectivesList: User;

  constructor(private objData: ObjectivesService, private user: LoginService) { }

  ngOnInit(): void {
    this.objData.checkComplete();

    this.objData.getObjectives().subscribe((response) => {
      console.log(response);
      this.objectivesList = response;
    }
  );

    if (this.user.getUsername() == 'Guest'){
      this.userPointCount = 0;
    }else{
      //this.userPointCount = this.user.getUserPoints();
    }
    // if(this.objData.dailyObj2 == this.objData.dailyObj3){
    //   this.objData.dailyObj3 = this.objData.randomDailyObj();
    // }

    // if(this.objData.weeklyObj == this.objData.weeklyObj2 || this.objData.weeklyObj3){
    //   this.objData.weeklyObj = this.objData.randomWeeklyObj();
    // }

    // if(this.objData.weeklyObj2 == this.objData.weeklyObj || this.objData.weeklyObj3){
    //   this.objData.weeklyObj2 = this.objData.randomWeeklyObj();
    // }

    // if(this.objData.weeklyObj3 == this.objData.weeklyObj || this.objData.weeklyObj2){
    //   this.objData.weeklyObj3 = this.objData.randomWeeklyObj();
    // }
  }

  checkValue(){
    this.objData.checkValue();
    this.value = this.objData.getValue();
    this.value1 = this.objData.value1;
    this.progressBar = this.objData.getProgressBar();
  }
}
