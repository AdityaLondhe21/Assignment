import { CurrencyPipe } from '@angular/common';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'money'
})
export class CurrencyConverterPipe implements PipeTransform {

  transform(value: number, ...args: string[]): string | null {
    let currencyCode = args[0];
    switch (currencyCode) {
      case 'INR':
        return "₹"+value;
      case 'USD':
        return "$"+(value)/87.46;
      case 'JPY':
        return "¥"+(value)/0.58;
      case 'SAR':
        return "SR "+(value)/23.31;
      case 'EUR':
        return "€"+(value)/93.64 ;
      case 'AUD':
        return  "A$"+(value)/57.23 ;
      default:
        return "₹"+value;
    }
  }
}
