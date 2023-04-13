import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  date = new Date().getFullYear();
  showComponent: boolean = true;

  constructor(
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    this.router.events.subscribe((val) => {
      if (
        this.router.url === '/home'
        || this.router.url === '/login'
        || this.router.url === '/register'
        || this.router.url === '/posts'
        || this.router.url === '/contact'
        || this.router.url === '/about-us'
        || this.router.url === '/policy') {
        this.showComponent = true;
      } else {
        this.showComponent = false;
      }
    });

  }
}


