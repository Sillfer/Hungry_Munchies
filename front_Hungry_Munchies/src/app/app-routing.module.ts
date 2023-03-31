import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./components/pages/home/home.component";
import {PostsComponent} from "./components/pages/posts/posts.component";
import {PostsShowComponent} from "./components/pages/posts/posts-show/posts-show.component";
import {AuthorComponent} from "./components/pages/author/author.component";
import {AuthorShowComponent} from "./components/pages/author/author-show/author-show.component";
import {LoginComponent} from "./components/pages/login/login.component";
import {SignupComponent} from "./components/pages/signup/signup.component";
import {RestrictComponent} from "./components/pages/restrict/restrict.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'posts', component: PostsComponent},
  {path: 'posts/:id', component: PostsShowComponent},
  {path: 'authors', component: AuthorComponent},
  {path: 'authors/:id', component: AuthorShowComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'restrict/:id', component: RestrictComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
