import { Component } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';
import { CommonModule } from '@angular/common';
import { RegisterUserService } from '../services/register-user.service';

@Component({
  selector: 'app-netbanking',
  imports: [CommonModule,LoginComponent,SignupComponent],
  templateUrl: './netbanking.component.html',
  styleUrl: './netbanking.component.css'
})
export class NetbankingComponent {
  flag:boolean=true;
  constructor(public ru:RegisterUserService){}
  
  changeFlag(){
    this.flag=!this.flag;
  }
}
