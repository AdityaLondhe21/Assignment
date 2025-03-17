import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CircleComponent } from "./circle/circle.component";
import { CommonModule } from '@angular/common';
import { BankCalculatorComponent } from "./bank-calculator/bank-calculator.component";
import { CurrencyConverterPipe } from './pipes/currency-converter.pipe';
import { CurrencyConverterComponent } from "./currency-converter/currency-converter.component";

@Component({
  selector: 'app-root',
  imports: [CircleComponent, CommonModule, BankCalculatorComponent, CurrencyConverterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'CustomTagPipeDirAssignment';
}
