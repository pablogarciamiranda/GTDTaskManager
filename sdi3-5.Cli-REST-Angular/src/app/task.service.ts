import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { RequestOptions, RequestMethod, RequestOptionsArgs, Http , Headers } from '@angular/http';
import { Task } from "app/task";
import { Category } from "app/category";


@Injectable()
export class TaskService {
  private taskService: string = 'http://10.0.2.2:8280/sdi3-5.Web/rest/TaskServiceRs';
  private task: Task;
  private categoryId: number;

  constructor(private http: Http) {

  }

  fetchTasks(id:number): Observable<Task[]> {
    this.categoryId = id;
    //var header = this.generateHeader("admin1", "admin1"); 
    return this.http.get(this.taskService + '/tasks/categoryR/' + id).map(response => this.toTasks(response.json()));
  }

  fetchCategories(id:number): Observable<Task[]> {
    //var header = this.generateHeader("admin1", "admin1"); 
    return this.http.get(this.taskService + '/categories/userR/' + id).map(response => this.toCategories(response.json()));
  }

  toTasks(results: any[]): Task[] {
    return results.map((t: any) => <Task>{
      id: t.id,
      title: t.title,
      comments: t.comments,
      created: t.created,
      planned: t.planned,
      finished: t.finished,
      categoryId: t.categoryId,
      userId: t.userId
    });
  }

  toCategories(results: any[]): Category[] {
    return results.map((c: any) => <Task>{
      id: c.id,
      title: c.title,
      userId: c.userId,
    });
  }

  addTask(_title: string, _comments: string, _planned: string, _userId: number){
    var header = new Headers(); 
    header.append('Content-Type', 'application/json');

    var task = JSON.stringify({title: _title, comments: _comments, created: "", planned: _planned, finished: "", categoryId: this.categoryId, userId: _userId});
    
    this.http.put(this.taskService + '/tasks', task, {headers: header})
              .map(res => res.json())
              .subscribe(res=> console.log ("Value: " + res));
  }

  finishTask(id: number){
    this.http.post(this.taskService + '/tasks/finish/'+ id, "").subscribe();
  }

  private generateHeader(username, password) {
    var base64Creds = btoa(username + ":" + password);
    var auth = 'Basic ' + base64Creds;
    console.log(auth);
    var authHeader = new Headers();
    authHeader.append("Authorization", auth);

    return authHeader;
  }

  
}

