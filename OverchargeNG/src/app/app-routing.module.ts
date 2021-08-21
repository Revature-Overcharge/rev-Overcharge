import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { TimerComponent } from './components/timer/timer.component';
import { CardrunnerComponent } from './components/card-runner/card-runner.component';
import { LibraryComponent } from './components/library/library.component';
import { ObjectivesComponent } from './components/objectives/objectives.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'timer', component: TimerComponent},
  {path: 'login', component: LoginComponent},
  {path: 'library', component: LibraryComponent},
  {path: 'cardrunner', component: CardrunnerComponent },
  {path: 'objectives', component: ObjectivesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
