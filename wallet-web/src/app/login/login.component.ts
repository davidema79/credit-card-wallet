import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';

declare var $: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, AfterViewInit, OnDestroy {

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit(): void {
    $('#login_modal').modal({backdrop: 'static', keyboard: false});
  }


  ngOnDestroy(): void {
    $('#login_modal').hide();
    // $('.modal-backdrop').remove();
  }

}
