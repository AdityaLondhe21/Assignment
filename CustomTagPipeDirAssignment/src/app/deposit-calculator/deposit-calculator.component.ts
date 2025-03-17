import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'deposit-calculator',
  imports: [FormsModule,CommonModule],
  templateUrl: './deposit-calculator.component.html',
  styleUrl: './deposit-calculator.component.css'
})
export class DepositCalculatorComponent {
  depositAmount:number=0;
  depositTenure:number=0;

  interestRate:number=0.07;
  maturityAmount:number=0;

  calculateDeposit():void{
    if (this.depositTenure >= 10) {
        alert('Please enter valid values. Tenure should be less than or equal to 10 years.');
        return;
    }
    this.maturityAmount = this.depositAmount * Math.pow((1 + this.interestRate), this.depositTenure);
    this.maturityAmount = parseFloat(this.maturityAmount.toFixed(2));
  }
}
