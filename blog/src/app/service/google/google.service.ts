import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class GoogleService {
  private httpHeader:HttpHeaders;
  private host = environment.host;
  private url = environment.githubLoginUrl;


  constructor(private http:HttpClient) {
    this.httpHeader = new HttpHeaders();
    this.httpHeader.append('Content-Type', 'application/json');
  }

  getToken(profile:object){
    this.http.post('http://localhost8080/signIn/google',profile,{headers:this.httpHeader}).toPromise()
      .then(r => {
        console.log(r);
      })
  }
}
