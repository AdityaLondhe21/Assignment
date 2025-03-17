import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CurrencyConverterPipe } from '../pipes/currency-converter.pipe';

@Component({
  selector: 'mutualfund-calculator',
  imports: [FormsModule,CommonModule],
  templateUrl: './mutualfund-calculator.component.html',
  styleUrl: './mutualfund-calculator.component.css'
})
export class MutualfundCalculatorComponent {
  monthlySIPAmount:number=0;
  duration:number=0;
  roi:number=0;
  returns:number=0;
  calculateTotalReturns(){
    let rate = this.roi/100;
    let totalAmount=0;
    for(let i=1;i<=this.duration;i++){
      totalAmount =totalAmount*(1+rate) + this.monthlySIPAmount
    }
    this.returns=totalAmount;
  }
}
