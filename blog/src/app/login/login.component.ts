import {Component, OnInit} from '@angular/core';
import {GithubService} from "../service/github/github.service";
import {environment} from "../../environments/environment";
import {AuthService, FacebookLoginProvider} from "angular4-social-login";
import {GoogleService} from "../service/google/google.service";

declare const gapi: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  authUrl = environment.githubAuthUrl + environment.githubClientId + environment.githubRedirectUrl;

  constructor(private github: GithubService, private google:GoogleService) {
  }

  ngOnInit() {
  }

  public auth2: any;

  public googleInit() {
    gapi.load('auth2', () => {
      this.auth2 = gapi.auth2.init({
        client_id: '630788589255-83v3jbn80c4qesnsmet0nrr0006je0hc.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
        scope: 'profile email'
      });
      this.attachSignin(document.getElementById('googleBtn'));
    });
  }

  public attachSignin(element) {
    this.auth2.attachClickHandler(element, {},
      (googleUser) => {

        let profile = googleUser.getBasicProfile();
        console.log('Token || ' + googleUser.getAuthResponse().id_token);
        console.log('ID: ' + profile.getId());
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());
        let token = this.google.getToken(profile);
        console.log(token);
        }, (error) => {
        alert(JSON.stringify(error, undefined, 2));
      });
  }

  ngAfterViewInit() {
    this.googleInit();

  }
}
