import { Component, OnInit } from '@angular/core';
import { TaskService } from "app/task.service";
import { Task } from "app/task";
import { Category } from "app/category";
import { UserService } from "app/user.service";

@Component({
  selector: 'app-list-categories',
  templateUrl: './list-categories.component.html',
  styleUrls: ['./list-categories.component.css']
})
export class ListCategoriesComponent implements OnInit {

  private tService: TaskService;
  private uService: UserService;
  private categories: Category[];
  private userId: number;

  constructor(taskService: TaskService, userService: UserService) {
    this.tService = taskService;
    this.uService = userService;
  }

  ngOnInit() {
    this.loadCategories(this.uService.getUserId());
  }

  loadCategories(id: number) {
    this.tService.fetchCategories(id).subscribe(
      categories => this.categories = categories,
      error => console.log('Error fetching categories')
    );
  }
}
