import { Component, OnInit } from '@angular/core';
import {GithubService} from "../service/github/github.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private github:GithubService) { }

  ngOnInit() {
  }

  githubLogin(){

    console.log(this.github.githubSignIn());
  }
}
