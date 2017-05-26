import { Component, OnInit } from '@angular/core';
import {CreditCard} from "../credit-card-details/credit-card.model";
import {CreditCardsService} from "../credit-cards-list/credit-cards.service";

@Component({
  selector: 'app-credit-card-search',
  templateUrl: './credit-card-search.component.html',
  styleUrls: ['./credit-card-search.component.css']
})
export class CreditCardSearchComponent implements OnInit {

  public creditCardList: Array<CreditCard>;

  public searchParam: string;

  public isEmptyResult: boolean;

  constructor(private _creditCardService: CreditCardsService) { }

  ngOnInit() {
    this.isEmptyResult = false;
  }
  public searchCreditCards() {
    this._creditCardService.search(this.searchParam)
      .subscribe(
        data => {
          this.creditCardList = data;
          this.isEmptyResult = (this.creditCardList.length === 0 );
        }
      );

  }
}
