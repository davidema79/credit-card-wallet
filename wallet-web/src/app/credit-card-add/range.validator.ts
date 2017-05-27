import {AbstractControl, ValidatorFn} from "@angular/forms";

export function rangeValidator(valueRange: number[]): ValidatorFn {
  return (control: AbstractControl): {[key: string]: any} => {
    const numberToTest: number = control.value;
    const no: boolean = numberToTest < valueRange[0] ||  numberToTest > valueRange[1];
    return no ? {'outOfRange': {numberToTest}} : null;
  };
}
