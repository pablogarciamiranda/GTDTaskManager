import { Component, OnInit } from '@angular/core';
import { Task } from "app/task";
import { TaskService } from "app/task.service";
import { ActivatedRoute, Params } from "@angular/router";
import { UserService } from "app/user.service";

@Component({
  selector: 'app-list-tasks',
  templateUrl: './list-tasks.component.html',
  styleUrls: ['./list-tasks.component.css']
})
export class ListTasksComponent implements OnInit {

  private tasks: Task[];
  private tService: TaskService;
  private uService: UserService;

  private title: string;
  private comments: string;
  private created: string;
  private finished: string;
  private planned: string;
  private categoryId: string;

  constructor(private taskService: TaskService, private userService: UserService, private route: ActivatedRoute) {
    this.tService = taskService;
    this.uService = userService;
    this.loadTasks();
  }

  ngOnInit() {
  }

  loadTasks(){
    this.route.params.subscribe(
      (params: Params) =>(
        this.tService.fetchTasks(params['id'])).subscribe(
          tasks => this.tasks = tasks,
          error => console.log('Error fetching tasks'))
    );
  }

  addTask(title: string, comments: string, planned: string){
    this.tService.addTask(title, comments, planned, this.uService.getUserId());
    setTimeout(() =>
    {
    this.loadTasks();
    },
    500);
   
  }

  finishTask(id:number){
    this.tService.finishTask(id);
      setTimeout(() =>
    {
    this.loadTasks();
    },
    500);
  }
}
