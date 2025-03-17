import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

type loanTypeDetails={
  type:string,
  interestRate:number,
  maxTenure:number,
  minAmount:number,
  maxAmount:number
}

@Component({
  selector: 'loan-calculator',
  imports: [FormsModule],
  templateUrl: './loan-calculator.component.html',
  styleUrl: './loan-calculator.component.css'
})

export class LoanCalculatorComponent {
  name:string="";
  loanAmount:number=0;
  type:string="Home";
  loanType:loanTypeDetails={type:"Home",interestRate:9,maxTenure:30,minAmount:500000,maxAmount:10000000};
  loanTenure:number=0;

  emi:number=0;
  totalPayment:number=0;
  totalInterest:number=0;

  setLoanType():void{
    if(this.type==="Car"){
      this.loanType={type:"Car",interestRate:11,maxTenure:7,minAmount:100000,maxAmount:1500000};
    }
    else if(this.type==="Personal"){
      this.loanType={type:"Personal",interestRate:15,maxTenure:5,minAmount:10000,maxAmount:500000};
    }
    else{
      this.loanType={type:"Home",interestRate:9,maxTenure:30,minAmount:500000,maxAmount:10000000};
    }
    console.log(this.loanType)
  }

  calculateLoan():void {
    if (this.loanTenure>this.loanType.maxTenure) {
        alert(`Loan tenure exceeds the maximum allowed (${this.loanType.maxTenure} years) for the selected loan type`);
        return;
    }
    if (this.loanAmount<this.loanType.minAmount || this.loanAmount>this.loanType.maxAmount) {
        alert(`Loan amount is out of the allowed range (${this.loanType.minAmount},${this.loanType.minAmount}) for the selected loan type`);
        return;
    }
    if (!this.loanAmount || !this.loanTenure) {
        alert('Please fill all the fields');
        return;
    }
    
    const interestRate = this.loanType.interestRate / 100;
    const tenureInMonths = this.loanTenure * 12;
    const monthlyInterestRate = interestRate / 12;

    this.emi = (this.loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureInMonths)) / (Math.pow(1 + monthlyInterestRate, tenureInMonths) - 1);
    this.totalPayment = this.emi * tenureInMonths;
    this.totalInterest = this.totalPayment - this.loanAmount;

    this.emi = parseFloat(this.emi.toFixed(2));
    this.totalPayment = parseFloat(this.totalPayment.toFixed(2));
    this.totalInterest = parseFloat(this.totalInterest.toFixed(2));
  }
}


