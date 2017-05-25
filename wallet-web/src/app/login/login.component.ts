import {AfterViewInit, Component, OnDestroy, OnInit} from "@angular/core";
import {AuthenticationService} from "../auth/authentication.service";
import {Router} from "@angular/router";

declare var $: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, AfterViewInit, OnDestroy {

  public username: string;
  public password: string;

  public error: boolean = false;

  constructor(private _authService: AuthenticationService,
              private _router: Router) {
  }

  ngOnInit() {
    this.username = null;
    this.password = null;
  }

  ngAfterViewInit(): void {
    $('#login_modal').modal({backdrop: 'static', keyboard: false});
  }


  ngOnDestroy(): void {
    $('#login_modal').hide();
    // $('.modal-backdrop').remove();
  }

  resetError(): void {
    this.error = false;
  }

  onLogin() {
    this._authService.login(this.username, this.password).subscribe(
      data => {
        console.info("User logged in:", data.username);
        this.error = false;
        this._router.navigate(['/']);
      },
      error => {
        this.error = true;
        // reset the password
        this.password = null;
      });
  }

}
