import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup, Validator, Validators} from "@angular/forms";
import {CustomValidators} from 'ng2-validation';
import {CreditCard} from "../credit-cards-list/credit-card.model";
import {CreditCardsService} from "../credit-cards-list/credit-cards.service";
import {Router} from "@angular/router";
import {isNullOrUndefined} from "util";

@Component({
    selector: 'app-credit-card-add',
    templateUrl: './credit-card-add.component.html',
    styleUrls: ['./credit-card-add.component.css']
})
export class CreditCardAddComponent implements OnInit {

    private DATE_EXP_PATTERN = '\d{2,2}\/\d{2,2}';

    public creditCardForm: FormGroup;

    constructor(private _formBuilder: FormBuilder,
                private _creditCardService: CreditCardsService,
    private _route: Router) {
    }

    ngOnInit() {
        this.initForm();
    }

    private initForm(): void {
        this.creditCardForm = this._formBuilder.group({
            'nameHolder': ['', Validators.required],
            'number': ['', Validators.compose([Validators.required, CustomValidators.creditCard])],
            'expDate': ['', Validators.compose([Validators.required, Validators.pattern(this.DATE_EXP_PATTERN)])]
        });
    }

    public OnSave() {
        const creditCard = new CreditCard();
        creditCard.nameHolder = this.creditCardForm.controls['nameHolder'].value;
        creditCard.cardNumber = this.creditCardForm.controls['number'].value;
        creditCard.dateExp = this.creditCardForm.controls['expDate'].value;

        this._creditCardService.save(creditCard).subscribe(
            data => {
                this.initForm();
                this._route.navigate(['/credid-cards']);
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

        return this.creditCardForm.controls['expDate'].touched && this.creditCardForm.controls['expDate'].invalid;
    }

}
