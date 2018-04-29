import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from "@angular/common/http";

@Injectable()
export class GithubService {

  constructor(private http:HttpClient) { }

  githubSignIn(){
    this.http.get("https://github.com/login/oauth/authorize?client_id=54a730b4c148dfd59769&redirect_uri:http://localhost:4200").toPromise();
  }

}
