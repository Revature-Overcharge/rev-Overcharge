
//Components
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { TimerComponent } from './components/timer/timer.component';
import { CardrunnerComponent } from './components/card-runner/card-runner.component';
import { LibraryComponent } from './components/library/library.component';
import { ObjectivesComponent } from './components/objectives/objectives.component';

//Modules
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { CountdownModule } from 'ngx-countdown';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



//Services
import { ObjectivesService } from './services/objectives.service';

//Pipes


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidenavComponent,
    HomeComponent,
    LoginComponent,
    TimerComponent,
    CardrunnerComponent,
    LibraryComponent,
    ObjectivesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    CountdownModule,
    FormsModule,
    BrowserAnimationsModule,
    NgbModule
  ],
  providers: [ObjectivesService, ObjectivesComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
