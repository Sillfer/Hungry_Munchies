import { Injectable } from '@angular/core';
import {UserModel} from "../models/user.model";
import {StaticService} from "./static.service";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {BehaviorSubject, catchError, Observable, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  users = new BehaviorSubject<UserModel[]>([]);
  users$ = this.users.asObservable();

  constructor(
    private http: HttpClient,
    private staticValue: StaticService
  ) { }

  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }

  getUsers(): Observable<any> {
    return this.http.get<any>(`${this.staticValue.baseUrl}authors/all`, this.staticValue.httpOptions)
      .pipe(
        catchError(this.handleError)
      );
  }


  getUser(user_id: number) {
    return this.http.get(this.staticValue.baseUrl + 'users/' + user_id, this.staticValue.httpOptions);
  }
}
