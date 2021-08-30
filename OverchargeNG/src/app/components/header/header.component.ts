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
  responseMessage: string = '';
  loggedIn : boolean;

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

    isGuest() :boolean {
    // console.log(this.loginServ.getUsername());
    if (localStorage.getItem("username") === "Guest") {
      return true;
    } else{
      return false;
    }
  }

  getUsername(): string {
    this.loggedIn = !this.isGuest();
    return this.loginServ.getUsername();
  }

  logout(): void {
    this.loggedIn = this.isGuest();
    this.loginServ.setUsername('Guest');
    this.responseMessage = 'Logging out';
  }

  updateObjValues() {
    this.objData.getObjectives().subscribe((response) => {
      this.loggedInUser = response;
      this.objList = this.loggedInUser.objectives;
    });
  }
}
