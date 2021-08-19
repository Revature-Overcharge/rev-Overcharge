import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardrunnerComponent } from './components/card-runner/card-runner.component';

const routes: Routes = [
  {path: 'cardrunner', component: CardrunnerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
