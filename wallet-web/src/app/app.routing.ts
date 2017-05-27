import {RouterModule, Routes} from "@angular/router";
import {environment} from "../environments/environment";
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {CreditCardsListComponent} from "./credit-cards-list/credit-cards-list.component";
import {HomeComponent} from "./home/home.component";
import {AuthGuardService} from "./guards/auth-guard.service";
import {CreditCardAddComponent} from "./credit-card-add/credit-card-add.component";
import {CreditCardSearchComponent} from "./credit-card-search/credit-card-search.component";


const ROUTES: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: HomeComponent
  },
  {
    path: 'login',
    pathMatch: 'full',
    component: LoginComponent
  },
  {
    path: 'signup',
    pathMatch: 'full',
    component: SignupComponent
  },
  {
    path: 'credit-cards',
    pathMatch: 'full',
    component: CreditCardsListComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'credit-cards/add',
    pathMatch: 'full',
    component: CreditCardAddComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'credit-cards/search',
    pathMatch: 'full',
    component: CreditCardSearchComponent,
    canActivate: [AuthGuardService]
  }
];

export const ROUTER_MODULE = RouterModule.forRoot(ROUTES, environment.production ? {enableTracing: false} : {enableTracing: true});

