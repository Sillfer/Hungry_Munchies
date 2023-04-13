import {Component, OnInit} from '@angular/core';
import {UserModel} from "../../../models/user.model";
import {PostModel} from "../../../models/post.model";
import {AuthService} from "../../../services/auth.service";
import {UserService} from "../../../services/user.service";
import {PostService} from "../../../services/post.service";
import {AuthorService} from "../../../services/author.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthorModel} from "../../../models/author.model";
import {Input} from "postcss";
import {CategoryInterface} from "../../create-post-dialog/Category.interface";

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})

export class UserDashboardComponent implements OnInit {
  user?: UserModel;
  author?: AuthorModel;
  post?: PostModel;
  createPopup: boolean = false;

  categories: CategoryInterface[] = [
    {id: 1, name: 'MOROCCAN'},
    {id: 2, name: 'ITALIAN'},
    {id: 3, name: 'FRENCH'},
    {id: 4, name: 'AMERICAN'},
    {id: 5, name: 'JAPANESE'},
  ];
  fileToUpload: File | null = null;
  postData: any = {
    title: '',
    content: '',
    category: '',
    image: '',
    status: "PENDING",
    steps: "",
    ingredients: "",
    authorId:1
  }

  constructor(
    public postService: PostService,
    public authorService: AuthorService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id']
    this.authorService.getAuthor(id).subscribe(
      {
        next: (receivedAuthor: AuthorModel) => {
          this.author = receivedAuthor;
          console.log(receivedAuthor);

        },
        error: (error) => {
          console.log(error);
        },
        complete: () => {
          // complete.
        }
      });
  }


  openCreatePopup() {
    this.createPopup = true;
  }

  closeCreatePopup() {
    this.createPopup = false;
  }

  createPost() {
    console.log(this.postData);
    this.postService.createPost(this.postData).subscribe((data: any) => {
      console.log(data);
      this.closeCreatePopup();
    });
  }

  imageHandler() {
    const path :any = this.fileToUpload;
    this.postData.image = path.replace("C:\\fakepath\\", "");
    console.log(this.postData.image);


  }
}


