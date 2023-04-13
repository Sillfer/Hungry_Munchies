import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../services/auth.service";
import {UserService} from "../../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-main-header',
  templateUrl: './main-header.component.html',
  styleUrls: ['./main-header.component.css']
})
export class MainHeaderComponent implements OnInit{

  constructor(
    public authService: AuthService,
    public userService: UserService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('access_token');
  }

  showMenu = false;
  id: any;

  logout() {
    this.authService.doLogout();
  }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id']
    console.log(this.authService.getToken())
  }


}
