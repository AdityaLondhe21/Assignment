import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { RegisterUserService } from '../services/register-user.service';

@Component({
  selector: 'app-signup',
  imports: [FormsModule,CommonModule,ReactiveFormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  userForm:any;

  constructor(public ru:RegisterUserService){}

  ngOnInit(){
    this.userForm = new FormGroup({
      customerID: new FormControl("", this.idValidator),
      username: new FormControl("", Validators.compose([
        Validators.minLength(5),
        Validators.pattern('^[^0-9]*$')
      ])),
      password: new FormControl("",Validators.compose([
        Validators.required,
        Validators.minLength(8),
        Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).+$')
      ])),
      confirmPassword: new FormControl("",this.matchPasswordValidator),
      accountNo: new FormControl("",Validators.compose([
        Validators.minLength(6),
        // Validators.pattern()
      ]))
    });
    
  }
  idValidator(control:any):any{
    if(control.value.length == 7 && /^\d+$/.test(control.value)){
      return {user:true}
    }
  }
  matchPasswordValidator(control: any):any {
    if (control.value === this.userForm.controls['password'].value) {
      return { passwordMismatch: true };
    }
  }

}
