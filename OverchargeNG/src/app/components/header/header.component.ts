import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ObjectivesService } from 'src/app/services/objectives.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  popoverHTML: string = "<div><p><b>Daily</b></p><ul><li> Login </li><div class='progress'><div class='{{progressBar}}' role='progressbar' aria-valuenow='50' aria-valuemin='0' aria-valuemax='100' style='width:25%'></div></div><li> Create A Set </li><div class='progress'><div class={{progressBar}} role='progressbar' aria-valuenow='50' aria-valuemin='0' aria-valuemax='100' style='width:{{value}}%'></div></div><li> Create 3 Cards  1/3</li><div class='progress'><div class={{progressBar}} role='progressbar' aria-valuenow='50' aria-valuemin='0' aria-valuemax='100' style='width:{{value}}%'></div></div></ul></div><br><div><p><b>Weekly</b></p><ul><li> Create 5 Sets 1/5</li><div class='progress'><div class={{progressBar}} role='progressbar' aria-valuenow='50' aria-valuemin='0' aria-valuemax='100' style='width:{{value}}%'></div></div><li> Rank a Set </li><div class='progress'><div class={{progressBar}} role='progressbar' aria-valuenow='50' aria-valuemin='0' aria-valuemax='100' style='width:{{value}}%'></div></div><li> Get a 5 Star Rank on your Set 4/5</li> <div class='progress'><div class={{progressBar}} role='progressbar' aria-valuenow='50' aria-valuemin='0'aria-valuemax='100' style='width:{{value}}%'></div></div></ul></div>";

  constructor() { }

  ngOnInit(): void {
  }

  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }

  logout() {
    console.log("Not yet Implemented");
  }
  
}
