import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfileSettingsComponent } from './profileSettings/profileSettings.component';
import { ObjectivesComponent } from './objectives/objectives.component';
import { LogInComponent } from './log-in/log-in.component';
import { CreateSetsComponent } from './create-sets/create-sets.component';
import { LibraryComponent } from './library/library.component';
import { StudyComponent } from './study/study.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'profileSettings', component: ProfileSettingsComponent },
  { path: 'objectives', component: ObjectivesComponent },
  { path: 'create', component: CreateSetsComponent },
  { path: 'login', component: LogInComponent },
  { path: 'library', component: LibraryComponent },
  { path: 'study', component: StudyComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
