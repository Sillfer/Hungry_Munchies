import {Injectable} from '@angular/core';
import {PostModel} from "../models/post.model";
import {BehaviorSubject, Observable} from "rxjs";
import {StaticService} from "./static.service";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private posts = new BehaviorSubject<PostModel[]>([]);
  public posts$ = this.posts.asObservable();
  createPopup: boolean = false;

  constructor(private http: HttpClient, private staticService: StaticService) {
  }

  getAllPosts() {
    return this.http.get<PostModel[]>(this.staticService.baseUrl + 'posts/all', this.staticService.httpOptions);
  }

  getAllPending() {
    return this.http.get<PostModel[]>(this.staticService.baseUrl + 'posts/pending', this.staticService.httpOptions);
  }

  getPost(id: number): Observable<PostModel> {
    return this.http.get<PostModel>(this.staticService.baseUrl + 'posts/' + id, this.staticService.httpOptions);
  }

  getRandomPost(): Observable<PostModel> {
    return this.http.get<PostModel>(this.staticService.baseUrl + 'posts/random', this.staticService.httpOptions);
  }

  updatePostStatus(id: number): Observable<PostModel> {
    const url = `${this.staticService.baseUrl}posts/${id}/status`;
    return this.http.put <PostModel>(url, this.staticService.httpOptions);
  }

  createPost(postData: any): Observable<PostModel> {
    console.log(postData);
    return this.http.post<PostModel>(this.staticService.baseUrl + 'posts/create', postData, this.staticService.httpOptions);
  }

}
