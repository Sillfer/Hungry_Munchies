import {Component, OnInit} from '@angular/core';
import {UserModel} from "../../../models/user.model";
import {AuthService} from "../../../services/auth.service";
import {UserService} from "../../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthorService} from "../../../services/author.service";
import {PostService} from "../../../services/post.service";
import {PostModel} from "../../../models/post.model";
import {map, Observable} from "rxjs";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  user?: UserModel;
  authorCount?: number;
  post?: PostModel;

  constructor(
    public authService: AuthService,
    public userService: UserService,
    public postService: PostService,
    public authorService: AuthorService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id']
    this.userService.getUser(id).subscribe(
      (receivedPost: any) => {
        this.user = receivedPost;
      },
      (error) => {
        console.log(error);
      },
      () => {
        // complete.
      });
    this.userService.getUsers().subscribe(
      (users: any) => {
        this.userService.users.next(users);
        console.log(users);
      },
      (error) => {
        console.log(error);
      }
    );

    this.authorService.getAuthorCount().subscribe(count => {
      this.authorCount = count;
    })
  }


  logout() {
    this.authService.doLogout();
  }


}
