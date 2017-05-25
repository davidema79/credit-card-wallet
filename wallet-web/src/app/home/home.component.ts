import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../auth/authentication.service";
import {UserDetails} from "../auth/user.model";
import {MyLocalStorageService} from "../auth/my-local-storage.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private userDetail: UserDetails;

  constructor(private _authService: AuthenticationService,
              private _storage: MyLocalStorageService,
              private _router: Router) { }

  get isLoggedIn(): boolean {
    return this._authService.isLoggedIn();
  }

  public ngOnInit() {
    if (this._authService.isLoggedIn()) {
      this.userDetail = this._storage.getCurrentUser();
    }
  }

  public OnOpenWallets(): void {
    this._router.navigate(['/credit-cards']);
  }

}
