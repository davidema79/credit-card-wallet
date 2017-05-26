import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import {CreditCard} from "../credit-card-details/credit-card.model";
import {Observable} from "rxjs/Observable";
import {environment} from "../../environments/environment";

@Injectable()
export class CreditCardsService {

  private urlApi = environment.BACKEND_URL + "api/credit-cards/";

  constructor(private _http: Http) { }


  public getList(): Observable<Array<CreditCard>> {
    const headers = new Headers();
    headers.set('Content-Type', 'application/json');

    const args = new RequestOptions();
    args.headers = headers;
    args.withCredentials = true;

    return this._http.get(this.urlApi, args).map(
      data => {
        return data.json() as Array<CreditCard>;
    });
  }

  public save(creditCard: CreditCard): Observable<CreditCard> {
    const headers = new Headers();
    headers.set('Content-Type', 'application/json');

    const args = new RequestOptions();
    args.headers = headers;
    args.withCredentials = true;

    return this._http.post(this.urlApi + 'save', creditCard, args).map(
        data => {
          return data.json() as CreditCard;
        });
  }

}
