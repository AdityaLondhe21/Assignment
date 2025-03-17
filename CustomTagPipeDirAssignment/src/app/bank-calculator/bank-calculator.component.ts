import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LoanCalculatorComponent } from "../loan-calculator/loan-calculator.component";
import { DepositCalculatorComponent } from "../deposit-calculator/deposit-calculator.component";
import { MutualfundCalculatorComponent } from "../mutualfund-calculator/mutualfund-calculator.component";

@Component({
  selector: 'app-bank-calculator',
  imports: [CommonModule, FormsModule, LoanCalculatorComponent, DepositCalculatorComponent, MutualfundCalculatorComponent],
  templateUrl: './bank-calculator.component.html',
  styleUrls: ['./bank-calculator.component.css']
})
export class BankCalculatorComponent {
  selectedInvestment: string = '';
}
