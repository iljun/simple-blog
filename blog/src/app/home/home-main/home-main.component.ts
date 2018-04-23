import { Component, OnInit } from '@angular/core';
import {PostService} from "../../service/post.service";
import {PostList} from "./dto/post-list";

@Component({
  selector: 'app-home-main',
  templateUrl: './home-main.component.html',
  styleUrls: ['./home-main.component.css']
})
export class HomeMainComponent implements OnInit {

  // private postList:PostList[];
  private pageNumber:1;

  constructor(private postService:PostService) { }

  ngOnInit() {
    // this.postList = this.postService.getList(this.pageNumber);
    this.pageNumber++;
  }

  next(){
    // this.postList = this.postService.getList(this.pageNumber);
    this.pageNumber++;
  }

}
