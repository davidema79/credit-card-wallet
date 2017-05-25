import {EventEmitter, Injectable} from "@angular/core";
import {MyLocalStorageService} from "./my-local-storage.service";
import {UserDetails} from "./user.model";
import {Observable} from "rxjs/Observable";
import {Headers, Http, RequestOptions} from "@angular/http";
import {environment} from "../../environments/environment";
import {isNullOrUndefined} from "util";
import {Router} from "@angular/router";
import {CookieService} from "ngx-cookie-service";
import {SignUpUser} from "../signup/signup-user.model";
import {asElementData} from "@angular/core/src/view";

@Injectable()
export class AuthenticationService {

  private emitAuthenticationEvent = new EventEmitter<boolean>();

  constructor(private _http: Http,
              private _storage: MyLocalStorageService,
              private _router: Router,
              private _cookieServ: CookieService) {
  }


  public login(username: string, password: string): Observable<UserDetails> {
    const urlLogin = environment.BACKEND_URL + "login";

    const headers = new Headers();
    headers.set('Content-Type', 'application/x-www-form-urlencoded');

    const body = "username=" + username + "&" + "password=" + password;

    const args = new RequestOptions();
    args.headers = headers;
    args.withCredentials = true;

    return this._http.post(urlLogin, body, args).map(
      res => {
        return res.json() as UserDetails;
      }
    ).do(
      data => {
        this._storage.saveCurrentUser(data);

        this.emitAuthenticationEvent.emit(true);
      }
    );
  }

  public signUp(userDetails: SignUpUser): Observable<UserDetails> {
    const urlSignup = environment.BACKEND_URL + "api/users/signup";

    const headers = new Headers();
    headers.set('Content-Type', 'application/json');

    const args = new RequestOptions();
    args.headers = headers;
    args.withCredentials = true;

    return this._http.post(urlSignup, userDetails, args)
      .map( res => {
        return res.json() as UserDetails;
      });
  }

  public isLoggedIn(): boolean {
    return !isNullOrUndefined(this._storage.getCurrentUser());
  }


  public clearAuthentication() {
    this._storage.removeCurrentUser();
    this.emitAuthenticationEvent.emit(false);

    this._cookieServ.deleteAll();
    this._router.navigate(['/signin']);
  }

  public getEmitterAuthenticationEvent(): EventEmitter<boolean> {
    return this.emitAuthenticationEvent;
  }

}
