import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CreditCard} from "../credit-card.model";

@Component({
  selector: 'app-credit-card-details',
  templateUrl: './credit-card-details.component.html',
  styleUrls: ['./credit-card-details.component.css']
})
export class CreditCardDetailsComponent implements OnInit {

  @Input('creditCard') creditCard: CreditCard;

  @Output('onModify') creditCardEmitter = new EventEmitter<CreditCard>();

  constructor() { }

  ngOnInit() {
  }

}
