import { Component, OnInit } from '@angular/core';
import { CountdownConfig, CountdownEvent } from 'ngx-countdown';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.css'],
  host: {
    '[class.card]': `true`,
    
    '[class.text-center]': `true`,
  },
  template: `
    <div class="card-header">
      Actions
      <view-code name="actions"></view-code>
    </div>
    <div class="card-body">
      <countdown #cd (event)="handleEvent($event)" [config]="{ leftTime: 30 }"></countdown>
      <div>
        <button (click)="cd.pause()" class="btn btn-link btn-sm">pause</button>
        <button (click)="cd.resume()" class="btn btn-link btn-sm">resume</button>
        <button (click)="cd.stop()" class="btn btn-link btn-sm">stop</button>
        <button (click)="cd.restart()" class="btn btn-link btn-sm">restart</button>
      </div>
      <div class="alert alert-light">TIPS: Open console panel in chrome</div>
    </div>`
  // changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TimerComponent implements OnInit {
  config: CountdownConfig = {
    leftTime: 60,
    format: 'HH:mm:ss',
    prettyText: (text) => {
      return text
        .split(':')
        .map((v) => `<span class="item">${v}</span>`)
        .join('');
    },
  };

  handleEvent(e: CountdownEvent) {
    console.log('Actions', e);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
