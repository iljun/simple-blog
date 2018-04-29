import { Component, OnInit } from '@angular/core';
import {GithubService} from "../service/github/github.service";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private github:GithubService) { }

  authUrl = environment.githubAuthUrl + environment.githubClientId + environment.githubRedirectUrl;

  ngOnInit() {

  }

  // githubLogin(){
  //
  //   console.log(this.github.githubSignIn());
  // }
}
