import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable()
export class GithubService {

  private httpHeader:HttpHeaders;
  private host = environment.host;
  private url = environment.githubUrl;

  constructor(private http:HttpClient) {
    this.httpHeader = new HttpHeaders();
    this.httpHeader.append('Content-Type', 'application/json');
  }

  githubSignIn(code:String){

    //TODO Token저장
    this.http.post(this.host + this.url,JSON.stringify(code)).toPromise();
  }

}
