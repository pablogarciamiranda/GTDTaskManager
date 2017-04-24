import { Component, OnInit } from '@angular/core';
import { UserService } from "app/user.service";
import { User } from "app/user";
import { Router } from "@angular/router";
import { TaskService } from "app/task.service";
import { Category } from "app/category";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private uService: UserService;
  private tService: TaskService;
  private users: User[];
  private categories: Category[];
  private login: string;
  private password: string;

  constructor(userService: UserService, taskService: TaskService, private router: Router) { 
    this.uService = userService;
    this.tService = taskService;
    this.loadUsers();
  }

  ngOnInit() {
  }

  loadUsers() {
    this.uService.fetchUsers().subscribe(
      users => this.users = users,
      error => console.log('Error fetching users')
    );
  }

  loadCategories(id: number) {
    this.tService.fetchCategories(id).subscribe(
      categories => this.categories = categories,
      error => console.log('Error fetching categories')
    );
  }

  validate(login: string, password:string){
    for (let user of this.users){
      if (user.login == login && user.password == password){
        this.uService.setUserId(user.id);
        this.router.navigate(['/categories']);
      }
    }
  }
}
