import { Injectable } from '@angular/core';
import { Http, Headers } from "@angular/http";
import { User } from "app/user";
import { Observable } from "rxjs/Observable";

@Injectable()
export class UserService {
  private adminService: string = 'http://10.0.2.2:8280/sdi3-5.Web/rest/AdminServiceRs';
  private userId: number;

  constructor(private http: Http) {
    
  }

  fetchUsers(): Observable<User[]> {
    //var header = this.generateHeader("admin1", "admin1"); 

    //console.log(header);
    return this.http.get(this.adminService + '/usersR').map(response => this.toUsers(response.json()));
  }

  toUsers(results: any[]): User[] {
    return results.map((u: any) => <User>{
      id: u.id,
      login: u.login,
      email: u.email,
      password: u.password,
      isAdmin: u.isAdmin,
      status: u.status,
    });
  }

  setUserId(id:number){
    this.userId = id;
  }

  getUserId():number{
    return this.userId;
  }

    /**
   * Generate HTTP header using HTTP basic Auth
   */
  private generateHeader(username, password) {

    var base64Creds = btoa(username + ":" + password);
    var auth = 'Basic ' + base64Creds;
    console.log(auth);
    var authHeader = new Headers();
    authHeader.append("Authorization", auth);
    authHeader.append("Access-Control-Allow-Credentials", "true");
    return authHeader;
  }

} 
