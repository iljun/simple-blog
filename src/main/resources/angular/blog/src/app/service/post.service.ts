import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {SavePostDto} from "../post/dto/save-post-dto";

@Injectable()
export class PostService {

  private host = environment.host;
  private post = environment.postUrl;

  private httpHeader:HttpHeaders;

  constructor(private http:HttpClient) {
    this.httpHeader = new HttpHeaders();
    this.httpHeader.append('Content-Type', 'application/json');
  }

  savePost(savePostDto:SavePostDto){
    this.http.post(this.host+this.post,this.httpHeader).toPromise();
  }

  getList(pageCount:Number){
    // return this.http.get(this.host+this.post+'?pageCount='+pageCount,this.httpHeader).toPromise();
  }
}
