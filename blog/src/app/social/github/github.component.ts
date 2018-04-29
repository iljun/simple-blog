import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {GithubService} from "../../service/github/github.service";

@Component({
  selector: 'app-github',
  templateUrl: './github.component.html',
  styleUrls: ['./github.component.css']
})
export class GithubComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private githubService:GithubService) { }

  ngOnInit() {
    let code = this.activatedRoute.snapshot.queryParams["code"];

    this.githubService.githubSignIn(code);
  }

}
