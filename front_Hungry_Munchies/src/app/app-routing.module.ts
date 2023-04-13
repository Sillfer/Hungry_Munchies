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
import {DashboardComponent} from "./components/pages/dashboard/dashboard.component";
import {AuthGuard} from "./services/auth.guard";
import {PageNotFoundComponent} from "./components/pages/page-not-found/page-not-found.component";
import {UserDashboardComponent} from "./components/pages/user-dashboard/user-dashboard.component";
import {TablePostComponent} from "./components/table-post/table-post.component";
import {PolicyComponent} from "./components/pages/policy/policy.component";
import {ContactComponent} from "./components/pages/contact/contact.component";
import {AboutUsComponent} from "./components/pages/about-us/about-us.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'posts', component: PostsComponent},
  {path: 'posts/:id', component: PostsShowComponent},
  {path: 'authors', component: AuthorComponent},
  {path: 'authors/:id', component: AuthorShowComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'pending', component: TablePostComponent},
  {path: 'policy', component: PolicyComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'about-us', component: AboutUsComponent},
  {path: 'admin-dashboard/:id', component: DashboardComponent, canActivate: [AuthGuard]},
  {path: 'profile/:id', component: UserDashboardComponent, canActivate: [AuthGuard]},
  {path: 'restrict/:id', component: RestrictComponent},
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
