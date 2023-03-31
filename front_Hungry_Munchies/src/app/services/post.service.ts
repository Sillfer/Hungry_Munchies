import {Injectable} from '@angular/core';
import {PostModel} from "../models/post.model";
import {BehaviorSubject, catchError, Observable, of, tap} from "rxjs";
import {StaticService} from "./static.service";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private posts = new BehaviorSubject<PostModel[]>([]);
  public posts$ = this.posts.asObservable();

  constructor(private http: HttpClient, private staticService: StaticService) {
  }

  getAllPosts(){
    return this.http.get<PostModel[]>(this.staticService.baseUrl + 'posts/all', this.staticService.httpOptions);
  }

  getPost(id: number): Observable<PostModel> {
    return this.http.get<PostModel>(this.staticService.baseUrl + 'posts/' + id, this.staticService.httpOptions);
  }


}
