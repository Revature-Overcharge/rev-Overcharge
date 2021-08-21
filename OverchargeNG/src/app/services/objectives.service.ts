import { Injectable } from '@angular/core';
import { ObjectivesComponent } from '../components/objectives/objectives.component';

@Injectable({
  providedIn: 'root'
})

export class ObjectivesService {

  constructor(private objData: ObjectivesComponent) { }

  getValue(){
    return this.objData.value;
  }

  getProgressBar(){
    return this.objData.progressBar;
  }
}
