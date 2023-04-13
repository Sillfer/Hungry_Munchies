import {Component, OnInit} from '@angular/core';
import {PostService} from "../../services/post.service";
import {CategoryInterface} from "./Category.interface";

@Component({
  selector: 'app-create-post-dialog',
  templateUrl: './create-post-dialog.component.html',
  styleUrls: ['./create-post-dialog.component.css']
})
export class CreatePostDialogComponent implements OnInit  {

  constructor(
    private postService: PostService,
  ) {
  }

  ngOnInit(): void {
  }

  createPost() {

  }





}
