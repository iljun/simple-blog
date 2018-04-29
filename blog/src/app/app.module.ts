import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';


import {AppComponent} from './app.component';
import {NavBarComponent} from './nav-bar/nav-bar.component';
import {HomeHeaderComponent} from './home/home-header/home-header.component';
import {HomeMainComponent} from './home/home-main/home-main.component';

import {PostService} from "./service/post.service";
import {GithubService} from "./service/github/github.service";
import {PostComponent} from './post/post/post.component';
import {RouterModule, Routes} from "@angular/router";
import {PostDetailComponent} from './post/post-detail/post-detail.component';
import {PostEditComponent} from './post/post-edit/post-edit.component';
import {LoginComponent} from './login/login.component';
import {SignUpComponent} from './sign-up/sign-up.component';

import { SocialLoginModule, AuthServiceConfig } from "angular4-social-login";
import { GoogleLoginProvider, FacebookLoginProvider } from "angular4-social-login";

const appRoutes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeMainComponent},
  {path: 'post', component: PostComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signUp', component: SignUpComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeHeaderComponent,
    HomeMainComponent,
    PostComponent,
    PostDetailComponent,
    PostEditComponent,
    LoginComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    PostService,
    GithubService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
