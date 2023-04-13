import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {StaticService} from "./static.service";
import {catchError, Observable, throwError} from "rxjs";
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  showComponent: boolean = true;
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  currentUser = {};

  constructor(
    private http: HttpClient,
    private staticValue: StaticService,
    public router: Router
  ) {
  }

  signUp(user: User): Observable<any> {
    let api = `${this.staticValue.baseUrl}auth/signup`;
    return this.http.post(api, user)
      .pipe(
        catchError(this.handleError)
      )
  }

  signIn(user: User) {
    return this.http.post<any>(`${this.staticValue.baseUrl}auth/signin`, user)
      .subscribe((res: any) => {
        localStorage.setItem('access_token', `${res.tokenType} ${res.accessToken}`)
        let role = JSON.parse(atob(res.accessToken.split('.')[1])).role;
        if (role === 'ROLE_MODERATOR') {
          console.log(res.id);
          this.router.navigate(['admin-dashboard/' + res.id]).then(r => console.log(r));
          this.showComponent = false;
        } else if (role === 'ROLE_USER') {
          console.log(res.id);
          this.router.navigate(['profile/' + res.id]).then(r => console.log(r));
          this.showComponent = false;
        } else {
          this.router.navigate(['home']).then(r => console.log(r));
          this.showComponent = true;
        }
      })
  }

  getToken() {
    return localStorage.getItem('access_token');
  }

  get isLoggedIn(): boolean {
    let authToken = localStorage.getItem('access_token');
    return (authToken !== null);
  }

  doLogout() {
    let removeToken = localStorage.removeItem('access_token');
    if (removeToken == null) {
      this.router.navigate(['home']);
    }
  }

  handleError(error: HttpErrorResponse) {
    let msg = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      msg = error.error.message;
    } else {
      // server-side error
      msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(msg);
  }


}

