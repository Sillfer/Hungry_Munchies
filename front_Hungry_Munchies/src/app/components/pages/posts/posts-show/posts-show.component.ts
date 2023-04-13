import {Component, OnInit} from '@angular/core';
import {PostModel} from "../../../../models/post.model";
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "../../../../services/post.service";
import {AuthorModel} from "../../../../models/author.model";

@Component({
  selector: 'app-posts-show',
  templateUrl: './posts-show.component.html',
  styleUrls: ['./posts-show.component.css']
})
export class PostsShowComponent implements OnInit{
  post?: PostModel;
  constructor(
    private activatedRoute: ActivatedRoute,
    private postService: PostService,
    private router: Router
  ) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params['id']
    this.postService.getPost(id).subscribe({
      next: (receivedPost: PostModel) => {
        this.post = receivedPost;
        console.log(this.post);
      },
      error: (error) => {
        console.log(error);
      },
      complete: () => {
        // complete.
      }
    });
  }
}
