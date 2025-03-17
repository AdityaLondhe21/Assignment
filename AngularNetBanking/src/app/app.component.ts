import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoanCalculatorComponent } from './loan-calculator/loan-calculator.component';
import { DepositCalculatorComponent } from './deposit-calculator/deposit-calculator.component';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FooterComponent } from './footer/footer.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NetbankingComponent } from './netbanking/netbanking.component';
import { NavigateService } from './services/navigate.service';

@Component({
  selector: 'app-root',
  imports: [FormsModule,CommonModule,NetbankingComponent,LoanCalculatorComponent,DepositCalculatorComponent,HeaderComponent,SidebarComponent,FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'AngularNetBanking';
  constructor(public nav:NavigateService){}
}
