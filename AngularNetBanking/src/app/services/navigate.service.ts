import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NavigateService {
  public page:string='Net Banking'
  constructor() { }
  navigateToPage(page:string){
    this.page=page;
  }
}
