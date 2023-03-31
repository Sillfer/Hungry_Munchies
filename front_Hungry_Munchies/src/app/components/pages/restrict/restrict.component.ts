import {Component, OnInit} from '@angular/core';
import {UserModel} from "../../../models/user.model";
import {AuthService} from "../../../services/auth.service";
import {UserService} from "../../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-restrict',
  templateUrl: './restrict.component.html',
  styleUrls: ['./restrict.component.css']
})
export class RestrictComponent implements OnInit{
  user?: UserModel;

  constructor(
    public authService: AuthService,
    public userService: UserService,
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
  }

  logout() {
    this.authService.doLogout();
  }
}
