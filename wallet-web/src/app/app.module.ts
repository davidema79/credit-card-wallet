import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {CreditCardsListComponent} from './credit-cards-list/credit-cards-list.component';
import {CreditCardDetailsComponent} from './credit-cards-list/credit-card-details/credit-card-details.component';
import {SignupComponent} from './signup/signup.component';
import {ROUTER_MODULE} from "./app.routing";
import { HomeComponent } from './home/home.component';
import {AuthGuardService} from "./guards/auth-guard.service";

@NgModule({
    declarations: [
        AppComponent,
        LoginComponent,
        CreditCardsListComponent,
        CreditCardDetailsComponent,
        SignupComponent,
        HomeComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpModule,
        ROUTER_MODULE
    ],
    providers: [
        AuthGuardService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
