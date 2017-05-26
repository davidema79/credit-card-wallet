import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {CustomFormsModule} from 'ng2-validation';
import {CookieService} from 'ngx-cookie-service';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {CreditCardsListComponent} from './credit-cards-list/credit-cards-list.component';
import {CreditCardDetailsComponent} from './credit-cards-list/credit-card-details/credit-card-details.component';
import {SignupComponent} from './signup/signup.component';
import {ROUTER_MODULE} from "./app.routing";
import { HomeComponent } from './home/home.component';
import {AuthGuardService} from "./guards/auth-guard.service";
import {AuthenticationService} from "./auth/authentication.service";
import {MyLocalStorageService} from "./auth/my-local-storage.service";
import {CreditCardsService} from "./credit-cards-list/credit-cards.service";
import { CreditCardDisplayPipe } from './credit-cards-list/credit-card-display.pipe';
import { CreditCardAddComponent } from './credit-card-add/credit-card-add.component';

@NgModule({
    declarations: [
        AppComponent,
        LoginComponent,
        CreditCardsListComponent,
        CreditCardDetailsComponent,
        SignupComponent,
        HomeComponent,
        CreditCardDisplayPipe,
        CreditCardAddComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        CustomFormsModule,
        HttpModule,
        ROUTER_MODULE
    ],
    providers: [
        AuthGuardService,
        AuthenticationService,
        MyLocalStorageService,
        CreditCardsService,
        CookieService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
