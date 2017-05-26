import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'creditCardDisplay'
})
export class CreditCardDisplayPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    const ccNumber: string =  value;

    const part1 = ccNumber.substr(0, 4);
    const part2 = ccNumber.substr(4, 4);
    const part3 = ccNumber.substr(8, 4);
    const part4 = ccNumber.substr(12, 4);

    const result = part1 + "-" + part2 + "-" + part3 + "-" + part4;

    return result;
  }

}
