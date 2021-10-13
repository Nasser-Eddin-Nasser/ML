import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'; 
import { HomeComponent } from './home/home.component';
import {ContactListComponent} from './contact-list/contact-list.component';
import {ContactCraeteComponent} from './contact-craete/contact-craete.component';
const routes: Routes = [
  {path:  "", pathMatch:  "full",redirectTo:  "home"},
  {path: "home", component: HomeComponent},
  {path: "table", component: ContactListComponent},
  {path: "create", component: ContactCraeteComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
