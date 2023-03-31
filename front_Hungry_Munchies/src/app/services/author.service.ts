import {Injectable} from '@angular/core';
import {AuthorModel} from "../models/author.model";
import {BehaviorSubject, catchError, Observable, of, tap} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {StaticService} from "./static.service";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  private authors = new BehaviorSubject<AuthorModel[]>([]);
  public authors$ = this.authors.asObservable();

  constructor(
    private http: HttpClient,
    private staticService: StaticService
  ) {
  }
  getAllAuthors(){
    return this.http.get<AuthorModel[]>(this.staticService.baseUrl + 'authors/all', this.staticService.httpOptions);
  }


  getAuthor(id: number): Observable<AuthorModel> {
    return this.http.get<AuthorModel>(this.staticService.baseUrl + 'authors/' + id, this.staticService.httpOptions);
  }
}
