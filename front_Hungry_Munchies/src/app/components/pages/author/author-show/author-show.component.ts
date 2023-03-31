import {Component, OnInit} from '@angular/core';
import {AuthorModel} from "../../../../models/author.model";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthorService} from "../../../../services/author.service";

@Component({
  selector: 'app-author-show',
  templateUrl: './author-show.component.html',
  styleUrls: ['./author-show.component.css']
})
export class AuthorShowComponent implements OnInit {

  author?: AuthorModel;

  constructor(
    private activatedRoute: ActivatedRoute,
    private authorService: AuthorService,
    private router: Router
  ) {
  }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params['id']
    this.authorService.getAuthor(id).subscribe(
      {
        next: (receivedAuthor: AuthorModel) => {
          this.author = receivedAuthor;

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


