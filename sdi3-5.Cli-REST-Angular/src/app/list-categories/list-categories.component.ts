import { Component, OnInit } from '@angular/core';
import { TaskService } from "app/task.service";
import { Task } from "app/task";
import { Category } from "app/category";

@Component({
  selector: 'app-list-categories',
  templateUrl: './list-categories.component.html',
  styleUrls: ['./list-categories.component.css']
})
export class ListCategoriesComponent implements OnInit {

  private service: TaskService;
  private categories: Category[];
  private userId: number;

  constructor(taskService: TaskService) {
    this.service = taskService;
  }

  ngOnInit() {
  }

  loadCategories(id:number) {
    this.service.fetchCategories(id).subscribe(
      categories => this.categories = categories,
      error => console.log('Error fetching categories')
    );
  }

  
}
