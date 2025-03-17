import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { RegisterUserService } from '../services/register-user.service';
import { User } from '../../types';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule,FormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  customerID:number=0;
  loginForm:any;
  constructor(public ru:RegisterUserService){}
  ngOnInit(){
    this.loginForm = new FormGroup({
      customerID: new FormControl("", Validators.compose([
      Validators.min(1000000),
      Validators.max(9999999),
      Validators.required
      ])),
      password: new FormControl("", Validators.compose([
      Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\W).+$/),
      Validators.minLength(8),
      Validators.required
      ]))
    });
  }
  
  validateUser(password:string){
    let user:User|undefined = this.ru.getUserById(this.customerID);
    if(!user){ 
      alert("User For this Customer ID doesn't exists")
      return;
    }
    if(user?.password===password){
      alert("Invalid Password or Customer ID")
      return;
    }
    this.ru.authoriseUser=true;
  }

}
