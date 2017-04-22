import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ListTasksComponent } from './list-tasks/list-tasks.component';
import { ListCategoriesComponent } from './list-categories/list-categories.component';
import { FinishTaskComponent } from './finish-task/finish-task.component';
import { AddTaskComponent } from './add-task/add-task.component';
import { TaskService } from "app/task.service";
import { AppRoutingModule } from "app/app-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    ListTasksComponent,
    ListCategoriesComponent,
    FinishTaskComponent,
    AddTaskComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [ TaskService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
