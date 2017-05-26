import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CreditCard} from "../credit-card-details/credit-card.model";
import {CreditCardsService} from "../credit-cards-list/credit-cards.service";
import {Router} from "@angular/router";
import {isNullOrUndefined} from "util";
import {rangeValidator} from "./range.validator";

@Component({
  selector: 'app-credit-card-add',
  templateUrl: './credit-card-add.component.html',
  styleUrls: ['./credit-card-add.component.css']
})
export class CreditCardAddComponent implements OnInit {

  private DATE_EXP_PATTERN = '\d{2,2}\/\d{2,2}';

  public creditCardForm: FormGroup;

  public error: boolean;
  public errorMessage: string;

  constructor(private _formBuilder: FormBuilder,
              private _creditCardService: CreditCardsService,
              private _route: Router) {
  }

  ngOnInit() {
    this.initForm();
    this.error = false;
    this.errorMessage = "";
  }

  private initForm(): void {
    this.creditCardForm = this._formBuilder.group({
      'nameHolder': ['', Validators.required],
      'number': ['', Validators.compose([Validators.required, Validators.pattern('[0-9]{16}')])],
      'dateExpMonth': ['', Validators.compose([Validators.required, rangeValidator([1, 12])])],
      'dateExpYear': ['', Validators.compose([Validators.required, rangeValidator([17, 99])])]
    });
  }

  public OnSave() {
    const creditCard = new CreditCard();
    creditCard.nameHolder = this.creditCardForm.controls['nameHolder'].value;
    creditCard.cardNumber = this.creditCardForm.controls['number'].value;
    creditCard.dateExpMonth = this.creditCardForm.controls['dateExpMonth'].value;
    creditCard.dateExpYear = this.creditCardForm.controls['dateExpYear'].value;

    this._creditCardService.save(creditCard).subscribe(
      data => {
        this.initForm();
        this.error = false;
        this.errorMessage = "";
        this._route.navigate(['/credid-cards']);
      },
      error2 => {
        this.error = true;
        this.errorMessage = error2.toString();
      }
    );
  }

  get isHolderInvalid(): boolean {
    if (isNullOrUndefined(this.creditCardForm)) {
      return false;
    }

    return this.creditCardForm.controls['nameHolder'].touched && this.creditCardForm.controls['nameHolder'].invalid;
  }

  get isNumberInvalid(): boolean {
    if (isNullOrUndefined(this.creditCardForm)) {
      return false;
    }

    return this.creditCardForm.controls['number'].touched && this.creditCardForm.controls['number'].invalid;
  }

  get isDateInvalid(): boolean {
    if (isNullOrUndefined(this.creditCardForm)) {
      return false;
    }

    const part1 = this.creditCardForm.controls['dateExpMonth'].touched && this.creditCardForm.controls['dateExpMonth'].invalid;
    const part2 = this.creditCardForm.controls['dateExpYear'].touched && this.creditCardForm.controls['dateExpYear'].invalid;

    return part1 || part2;
  }

}
