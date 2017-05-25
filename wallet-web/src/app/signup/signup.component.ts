import {AfterViewInit, Component, OnDestroy, OnInit} from "@angular/core";
import {AuthenticationService} from "../auth/authentication.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {isNullOrUndefined} from "util";
import {SignUpUser} from "./signup-user.model";
import {Router} from "@angular/router";

declare var $: any;

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit, AfterViewInit, OnDestroy {

  public MAX_USR_LENGHT = 20;
  public MIN_USR_LENGHT = 5;

  public MIN_PWD_LENGHT = 5;
  public MAX_PWD_LENGHT = 10;

  public signupForm: FormGroup;

  private _signupUser: SignUpUser;

  public error = false;
  public errorMessage = "";

  constructor(private _authService: AuthenticationService,
              private _formBuilder: FormBuilder,
              private _router: Router) {
  }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this._signupUser = new SignUpUser();
    this.signupForm = this._formBuilder.group({
      'username': [this._signupUser.username, Validators.compose([Validators.required, Validators.minLength(this.MIN_USR_LENGHT),
        Validators.maxLength(this.MAX_USR_LENGHT)])],
      'password': [this._signupUser.password, Validators.compose([Validators.required, Validators.minLength(this.MIN_PWD_LENGHT),
        Validators.maxLength(this.MAX_PWD_LENGHT)])]
    });
  }

  ngAfterViewInit(): void {
    $('#signup_modal').modal({backdrop: 'static', keyboard: false});
  }

  get  isUsernameInvalid(): boolean {
    if (isNullOrUndefined(this.signupForm)) {
      return false;
    }

    return this.signupForm.controls['username'].touched && this.signupForm.controls['username'].invalid;
  }

  get isPasswordInvalid(): boolean {
    if (isNullOrUndefined(this.signupForm)) {
      return false;
    }

    return this.signupForm.controls['password'].touched && this.signupForm.controls['password'].invalid;
  }

  ngOnDestroy(): void {
    $('#signup_modal').hide();
    // $('.modal-backdrop').remove();
  }


  public onSignUp() {
    this._authService.signUp(this._signupUser).subscribe(
      data => {
        this.error = false;
        this._router.navigate(['/']);
      },
      error => {
        this.error = true;
        this.errorMessage = error.json();
      }
    );
  }

  public resetError() {
    this.errorMessage = "";
    this.error = false;
  }

}
