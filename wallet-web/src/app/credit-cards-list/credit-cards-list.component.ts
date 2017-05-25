import { Component, OnInit } from '@angular/core';
import {CreditCardsService} from "./credit-cards.service";
import {CreditCard} from "./credit-card.model";

@Component({
  selector: 'app-credit-cards-list',
  templateUrl: './credit-cards-list.component.html',
  styleUrls: ['./credit-cards-list.component.css']
})
export class CreditCardsListComponent implements OnInit {

  public creditCardList: Array<CreditCard>;

  constructor(private _creditCardService: CreditCardsService) { }

  ngOnInit() {
    this._creditCardService.getList()
      .subscribe(
        data => {
          this.creditCardList = data;
        }
      );
  }

}
