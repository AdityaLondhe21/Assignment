import { Injectable } from '@angular/core';
import { User } from '../../types';

@Injectable({
  providedIn: 'root'
})
export class RegisterUserService {
  public users:User[]=[];
  constructor() { }
  public flag:boolean=true;
  public authoriseUser:boolean=false;
  ngOnInit(){
    const localData = localStorage.getItem('users');
    if (localData) {
      this.users = JSON.parse(localData);
    }
  }
  changeFlag(){
    this.flag=!this.flag;
  }
  checkcustomerID(id:number):boolean{
    for(let user of this.users){
      if(user.customerID===id){
        return true;
      }
    }
    return false;
  }
  registerUser(newUser: User): void {
    if (!this.checkcustomerID(newUser.customerID)) {
      this.users.push(newUser);
      localStorage.setItem('users', JSON.stringify(this.users));
    } else {
      throw new Error('User with this customer ID already exists.');
    }
  }
  getUserById(id: number): User | undefined {
    return this.users.find(user => user.customerID === id);
  }
}
