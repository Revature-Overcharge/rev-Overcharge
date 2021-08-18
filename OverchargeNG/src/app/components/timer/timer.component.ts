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
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  @ViewChild('cd', { static: false }) 
  countdown!: CountdownComponent;

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
  }

}
