import { Component, OnInit } from '@angular/core';
import { CountdownConfig } from 'ngx-countdown';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.css']
})
export class TimerComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  config: CountdownConfig = {
    leftTime: 50,
    demand: true
  };

  customTime = 3600;
  setCustomTime() {
    this.config = { leftTime: this.customTime, demand: true };
  }

}
