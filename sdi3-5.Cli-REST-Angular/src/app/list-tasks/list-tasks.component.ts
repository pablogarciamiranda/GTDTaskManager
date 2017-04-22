import { Component, OnInit } from '@angular/core';
import { Task } from "app/task";
import { TaskService } from "app/task.service";
import { ActivatedRoute, Params } from "@angular/router";

@Component({
  selector: 'app-list-tasks',
  templateUrl: './list-tasks.component.html',
  styleUrls: ['./list-tasks.component.css']
})
export class ListTasksComponent implements OnInit {

  private tasks: Task[];

  private title: string;
  private comments: string;
  private created: string;
  private finished: string;
  private planned: string;
  private categoryId: string;

  constructor(private taskService: TaskService, private route: ActivatedRoute) {
    this.loadTasks();
  }

  ngOnInit() {
  }

  loadTasks(){
    this.route.params.subscribe(
      (params: Params) =>
        this.taskService.fetchTasks(params['id']).subscribe(
          tasks => this.tasks = tasks,
          error => console.log('Error fetching tasks'))
    );
  }

  addTask(title: string, comments: string, created: string, planned: string, finished: string){
    var categoryId = this.route.params['id'];
    var catIdNumber = +categoryId;
    this.taskService.addTask(title, comments, created, planned, finished, catIdNumber, 1);
    this.loadTasks();
  }

  finishTask(id:number){
    this.taskService.finishTask(id);
    this.loadTasks();
  }
}
