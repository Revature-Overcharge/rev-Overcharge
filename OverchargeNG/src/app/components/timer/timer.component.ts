import { ChangeDetectionStrategy, Component, EventEmitter, OnChanges, OnInit, Output, SimpleChanges, ViewChild } from '@angular/core';
import { CountdownComponent, CountdownConfig, CountdownEvent } from 'ngx-countdown';
import { VirtualTimeScheduler } from 'rxjs';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class TimerComponent implements OnInit, OnChanges {
  @ViewChild('cd', { static: false }) 
  countdown!: CountdownComponent;

  break: TimerMode = new TimerMode("Break", 10*60);
  study: TimerMode = new TimerMode("Study", 50*60);
  mode!: TimerMode;
  config!: CountdownConfig;
  status: string = "Inactive";
  
  hours!: number;
  minutes!: number;
  customTime!: number;

  inputIsShown: boolean = false;

  constructor() {
    this.mode = this.study;
    this.config = this.mode.defaultConfig;
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    // this.countdown = this.timer.countdown;
    console.log("Changes",changes);
  }

  setCustomTime() {
    this.customTime = (this.hours*3600 + this.minutes*60);
    this.config = { 
      leftTime: this.customTime, 
      demand: true, 
      format: "HH:mm:ss"
    };
  }

  // @Output() newEvent = new EventEmitter<CountdownEvent>();
    
  handleEvent(e: CountdownEvent) {
    // console.log(e);
    // this.newEvent.emit(e);

    switch (e.action) {
      case 'start':
        this.status = "Active";
        break;
      case 'pause':
        this.status = "Paused";
        break;
      case 'restart':
        this.status = "Inactive";
        break;
      case 'done':
        this.status = "Complete";
        // alert(`The ${this.mode.name} timer is over!`);
        break;
      default:
        this.status = 'Error';
        break;
    }
  }

  toggleInput() {
    this.inputIsShown = !this.inputIsShown;
  }

  toggleMode() {
    // console.log(`Timer Before Mode: ${this.mode.name}`);
    console.log("Toggling timer mode...")
    if (this.mode.name === this.study.name) {
      this.mode = this.break;
    } else if (this.mode.name === this.break.name) {
      this.mode = this.study;
    }
    console.log(`Timer Mode: ${this.mode.name}`);
    this.countdown.config = this.mode.defaultConfig;
    this.countdown.restart();
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