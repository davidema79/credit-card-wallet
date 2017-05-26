import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CreditCard} from "../credit-card.model";
import {CreditCardsService} from "../credit-cards.service";

@Component({
  selector: 'app-credit-card-details',
  templateUrl: './credit-card-details.component.html',
  styleUrls: ['./credit-card-details.component.css']
})
export class CreditCardDetailsComponent implements OnInit {

  @Input('creditCard') creditCard: CreditCard;

  @Output('editCreditCard') creditCardEmitter = new EventEmitter<CreditCard>();

  public editMode: boolean;

  constructor(private _creditCardService: CreditCardsService) { }

  ngOnInit() {
    this.editMode = false;
  }

  editCreditCard() {
    this.editMode = true;
  }

  saveCreditCard() {
    this._creditCardService.save(this.creditCard)
        .subscribe(
            data => {
              this.editMode = false;
              this.creditCardEmitter.emit(this.creditCard);
              this.creditCard = data;
            }
        );
  }
}
