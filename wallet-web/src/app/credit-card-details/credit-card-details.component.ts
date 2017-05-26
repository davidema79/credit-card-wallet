import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CreditCard} from "./credit-card.model";
import {CreditCardsService} from "../credit-cards-list/credit-cards.service";

@Component({
  selector: 'app-credit-card-details',
  templateUrl: './credit-card-details.component.html',
  styleUrls: ['./credit-card-details.component.css']
})
export class CreditCardDetailsComponent implements OnInit {

  @Input('creditCard') creditCard: CreditCard;

  @Output('editCreditCard') creditCardEmitter = new EventEmitter<CreditCard>();

  public editMode: boolean;
  private oldValue: CreditCard;

  constructor(private _creditCardService: CreditCardsService) { }

  ngOnInit() {
    this.editMode = false;
  }

  editCreditCard() {
    this.editMode = true;
    this.oldValue = this.creditCard;
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

  cancelEdit() {
    this.editMode = false;
    this.creditCard = this.oldValue;
  }


  get isRangeInvalid(): boolean {
    const part1 = this.creditCard.dateExpMonth > 12 || this.creditCard.dateExpMonth < 1;
    const part2 = this.creditCard.dateExpYear > 99 || this.creditCard.dateExpYear < 17;

    return part1 || part2;
  }
}
