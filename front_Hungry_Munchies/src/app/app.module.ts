import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AuthorComponent} from "./components/pages/author/author.component";
import {AuthorShowComponent} from './components/pages/author/author-show/author-show.component';
import {HomeComponent} from './components/pages/home/home.component';
import {LoginComponent} from './components/pages/login/login.component';
import {SignupComponent} from './components/pages/signup/signup.component';
import {PostsComponent} from './components/pages/posts/posts.component';
import {PostsShowComponent} from './components/pages/posts/posts-show/posts-show.component';
import {RestrictComponent} from './components/pages/restrict/restrict.component';
import {FooterComponent} from './components/sides/footer/footer.component';
import {MainHeaderComponent} from './components/sides/main-header/main-header.component';
import {SideBarComponent} from './components/sides/side-bar/side-bar.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AuthInterceptor} from "./services/authconfig.interceptor";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { DashboardComponent } from './components/pages/dashboard/dashboard.component';
import { PageNotFoundComponent } from './components/pages/page-not-found/page-not-found.component';
import { UserDashboardComponent } from './components/pages/user-dashboard/user-dashboard.component';
import { TablePostComponent } from './components/table-post/table-post.component';
import { AboutUsComponent } from './components/pages/about-us/about-us.component';
import { PolicyComponent } from './components/pages/policy/policy.component';
import { ContactComponent } from './components/pages/contact/contact.component';
import { CreatePostDialogComponent } from './components/create-post-dialog/create-post-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthorComponent,
    AuthorShowComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    PostsComponent,
    PostsShowComponent,
    RestrictComponent,
    FooterComponent,
    MainHeaderComponent,
    SideBarComponent,
    DashboardComponent,
    PageNotFoundComponent,
    UserDashboardComponent,
    TablePostComponent,
    AboutUsComponent,
    PolicyComponent,
    ContactComponent,
    CreatePostDialogComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
