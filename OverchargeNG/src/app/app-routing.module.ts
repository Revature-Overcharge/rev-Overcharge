import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CardrunnerComponent } from './components/card-runner/card-runner.component';
import { LibraryComponent } from './components/library/library.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
 {path: 'library', component: LibraryComponent},
  {path: 'cardrunner', component: CardrunnerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
