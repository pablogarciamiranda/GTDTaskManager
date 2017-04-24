import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListCategoriesComponent } from "app/list-categories/list-categories.component";
import { ListTasksComponent } from "app/list-tasks/list-tasks.component";
import { LoginComponent } from "app/login/login.component";


const routes: Routes = [
  { 
    path: '', component: LoginComponent 
  },
  {
    path: 'categories', component: ListCategoriesComponent,
  },
  {
    path: 'categories/:id', component: ListTasksComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [  ]
})
export class AppRoutingModule { }
