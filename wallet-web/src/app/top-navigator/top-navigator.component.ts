import {Component, OnInit} from "@angular/core";
import {AuthenticationService} from "../auth/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-top-navigator',
  templateUrl: './top-navigator.component.html',
  styleUrls: ['./top-navigator.component.css']
})
export class TopNavigatorComponent implements OnInit {

  public isLoggedIn: boolean;

  constructor(private _auth: AuthenticationService, private _router: Router) {
  }

  ngOnInit() {
    this.isLoggedIn = this._auth.isLoggedIn();
    this._auth.getEmitterAuthenticationEvent().subscribe(
      eventValue => {
        this.isLoggedIn = eventValue;
      });
  }


  public OnLogout(): void {
    this._auth.clearAuthentication();
    this._router.navigate(['/login']);
  }

}
