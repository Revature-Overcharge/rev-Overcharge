import { Component, OnInit } from '@angular/core';
import { Objective } from 'src/app/models/objective';
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
  loggedInUser: User;
  objList: Objective[] = [];
  loggedIn: boolean;

  constructor(private objData: ObjectivesService, private user: LoginService) { }

  ngOnInit(): void {

    this.loggedIn = this.user.loggedIn;


    this.objData.getObjectives().subscribe((response) => {
      this.loggedInUser = response;
      console.log(this.loggedInUser.points);
      this.objList = this.loggedInUser.objectives;
      this.userPointCount = this.loggedInUser.points;
      console.log(this.objList);
    });
  }
}
