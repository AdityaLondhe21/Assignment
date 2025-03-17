import { Component } from '@angular/core';
import { CurrencyConverterPipe } from '../pipes/currency-converter.pipe';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'currency-converter',
  imports: [CurrencyConverterPipe, FormsModule],
  templateUrl: './currency-converter.component.html',
  styleUrl: './currency-converter.component.css'
})
export class CurrencyConverterComponent {
  amount: number = 0;
  selectedCurrency: string = 'INR';
  convertedAmount: string = "";
}
