import {Component, OnInit} from '@angular/core';
import {PostModel} from "../../../models/post.model";
import {PostService} from "../../../services/post.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  posts: any = [];


  constructor(private postService: PostService, private router: Router) {
  }

  ngOnInit(): void {
    this.postService.getRandomPost().subscribe(
      (post: PostModel) => {
        this.posts = post;
        console.log(this.posts);
      }
    );


  }

}
