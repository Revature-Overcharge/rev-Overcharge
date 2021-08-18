import { ChangeDetectionStrategy, Component, OnInit, ViewChild } from '@angular/core';
import { CountdownComponent, CountdownConfig, CountdownEvent } from 'ngx-countdown';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TimerComponent implements OnInit {
  @ViewChild('cd', { static: false }) 
  countdown!: CountdownComponent;

  break: TimerMode = new TimerMode("Break", 10*60);
  study: TimerMode = new TimerMode("Study", 50*60);
  mode!: TimerMode;
  config!: CountdownConfig;

  ngOnInit(): void {
    this.mode = this.study;
    this.config = this.mode.defaultConfig;
  }

  

  hours!: number;
  minutes!: number;
  customTime!: number;

  setCustomTime() {
    this.customTime = (this.hours*3600 + this.minutes*60);
    this.config = { 
      leftTime: this.customTime, 
      demand: true, 
      format: "HH:mm:ss"
    };
  }

  handleEvent(e: CountdownEvent) {
    console.log(e);
    if (e.action == 'done') {
      alert(`The ${this.mode.name} timer is over!`);
    }
  }

  toggleMode() {
    if (this.mode.name == this.study.name) {
      this.mode = this.break;
    } else if (this.mode.name == this.break.name) {
      this.mode = this.study;
    }
  }

}

class TimerMode {
  name: string;
  defaultTime: number;
  defaultConfig: CountdownConfig;

  constructor(name: string, defaultTime: number) {
    this.name = name;
    this.defaultTime = defaultTime;
    this.defaultConfig = {
      leftTime: this.defaultTime, 
      demand: true, 
      format: "HH:mm:ss"
    };
  }
}