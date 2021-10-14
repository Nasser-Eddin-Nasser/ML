import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'; 
import { HomeComponent } from './home/home.component';
import {MediaListComponent} from './media-list/media-list.component';
import {MediaInsertComponent} from './media-insert/media-insert.component';
const routes: Routes = [
  {path:  "", pathMatch:  "full",redirectTo:  "home"},
  {path: "home", component: HomeComponent},
  {path: "overview", component: MediaListComponent},
  {path: "insert", component: MediaInsertComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
