import { Component, EventEmitter, OnInit, Output} from '@angular/core';
import { ObjectivesService } from 'src/app/services/objectives.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  value: number;
  progressBar: string;

  constructor(private objData: ObjectivesService) { }

  ngOnInit(): void {
    this.updateValue();

    if (this.value == 100){
      this.progressBar = "progress-bar";
    }
  }

  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }

  logout() {
    console.log("Not yet Implemented");
  }
  
  updateValue(){
 
    this.value = this.objData.getValue();
    this.progressBar = this.objData.getProgressBar();
  }
}
