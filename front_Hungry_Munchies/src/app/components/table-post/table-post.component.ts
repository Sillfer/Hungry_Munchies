import {Component, OnInit} from '@angular/core';
import {PostModel} from "../../models/post.model";
import {PostService} from "../../services/post.service";
import {Router} from "@angular/router";
import {PostStatus} from "../../models/post.interface";

@Component({
  selector: 'app-table-post',
  templateUrl: './table-post.component.html',
  styleUrls: ['./table-post.component.css']
})
export class TablePostComponent implements OnInit {
  posts: PostModel[] = [];

  constructor(private postService: PostService, private router: Router) {
  }

  ngOnInit(): void {
    this.postService.getAllPending().subscribe(
      (posts: PostModel[]) => {
        this.posts = posts;
        console.log(this.posts);
      }
    );
  }

  updatePostStatus(id: number): void{
    this.postService.updatePostStatus(id)
      .subscribe(updatePost => {
        console.log('Post Updated', updatePost)
      }, error => {
        console.log('Error', error)
      })
  }

}
