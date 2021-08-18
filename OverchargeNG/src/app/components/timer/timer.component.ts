import { ChangeDetectionStrategy, Component, OnInit, ViewChild } from '@angular/core';
import { CountdownComponent, CountdownConfig, CountdownEvent } from 'ngx-countdown';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.css'],
  host: {
    '[class.card]': `true`,
    
    '[class.text-center]': `true`,
  },
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class TimerComponent implements OnInit {
  @ViewChild('cd', { static: false }) 
  countdown!: CountdownComponent;

  break: TimerMode = new TimerMode("Break", 10*60);
  study: TimerMode = new TimerMode("Study", 50*60);
  mode!: TimerMode;

  isShown: boolean = true;

  toggleShow() {

    this.isShown = ! this.isShown;
    
    }

  ngOnInit(): void {
    this.mode = this.study;
  }

  config: CountdownConfig = {
    leftTime: 3000,
    demand: true,
    format: 'HH:mm:ss'
  };

  hours: number;
  minutes: number;
  customTime: number;


  setCustomTime() {
    this.customTime = (this.hours*3600 + this.minutes*60);
    this.config = { leftTime: this.customTime, demand: true };
  }

  handleEvent(e: CountdownEvent) {
    console.log(e);
    if (e.action == 'done'){
      alert("Work Timer Complete!");
    }
    
  }

}

class TimerMode {
  name: string;
  defaultTime: number;

  constructor(name: string, defaultTime: number) {
    this.name = name;
    this.defaultTime = defaultTime;
  }
}