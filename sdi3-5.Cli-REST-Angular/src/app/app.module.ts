import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ListTasksComponent } from './list-tasks/list-tasks.component';
import { ListCategoriesComponent } from './list-categories/list-categories.component';
import { TaskService } from "app/task.service";
import { AppRoutingModule } from "app/app-routing.module";
import { UserService } from "app/user.service";
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    ListTasksComponent,
    ListCategoriesComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [ TaskService, UserService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
