import { Component, OnInit } from '@angular/core';
import { ObjectivesService } from 'src/app/services/objectives.service';

@Component({
  selector: 'app-objectives',
  templateUrl: './objectives.component.html',
  styleUrls: ['./objectives.component.css']
})
export class ObjectivesComponent implements OnInit {

  value: number;
  progressBar: string = "progress-bar progress-bar-striped progress-bar-animated";

  constructor(private objData: ObjectivesService) { }

  ngOnInit(): void {
    this.objData.checkComplete();
  }

  checkValue(){
    this.objData.checkValue();
    this.value = this.objData.getValue();
    this.progressBar = this.objData.getProgressBar();
  }
}
