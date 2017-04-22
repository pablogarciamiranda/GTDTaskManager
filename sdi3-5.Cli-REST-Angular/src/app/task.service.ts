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

  constructor(private http: Http) {

  }

  fetchTasks(id:number): Observable<Task[]> {
    return this.http.get(this.taskService + '/tasks/categoryR/' + id).map(response => this.toTasks(response.json()));
  }

  fetchCategories(id:number): Observable<Task[]> {
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

  addTask(_title: string, _comments: string, _created: string, _planned: string, _finished: string, _categoryId: number, _userId: number){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    var task = JSON.stringify({title: _title, comments: _comments, created: _created, planned: _planned, finished: _finished, _categoryId, userId: _userId});
    
    this.http.post(this.taskService + '/tasks', task, {headers: headers})
              .map(res => res.json())
              .subscribe(res=> console.log ("Value: " + res));
  }

  finishTask(id: number){
    this.http.post(this.taskService + '/tasks/finish/'+ id, "").subscribe();
  }

  
}

