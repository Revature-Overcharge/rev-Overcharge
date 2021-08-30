import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ObjectivesService } from 'src/app/services/objectives.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { User } from 'src/app/models/user';
import { Objective } from 'src/app/models/objective';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  loggedInUser: User;
  objList: Objective[] = [];
  progressBar: string =
    'progress-bar progress-bar-striped progress-bar-animated';

  responseMessage: string = '';
  loggedIn: boolean;
  loginPoints: boolean;

  constructor(
    private loginServ: LoginService,
    private router: Router,
    private modalService: NgbModal,
    private objData: ObjectivesService
  ) {}

  ngOnInit(): void {
    this.updateObjValues();
  }

  toggleSidebar(): void {
    this.toggleSidebarForMe.emit();
  }

  getUsername(): string {
    this.loggedIn = this.loginServ.loggedIn;
    return this.loginServ.getUsername();
  }

  logout(): void {
    this.loggedIn = !this.loggedIn;
    this.loginServ.setUsername('Guest');
    this.responseMessage = 'Logging out';
  }

  updateObjValues() {
    this.objData.getObjectives().subscribe((response) => {
      this.loggedInUser = response;
      console.log(this.loggedInUser.points);
      this.objList = this.loggedInUser.objectives;
    });
  }
}
