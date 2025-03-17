import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'circle',
  imports: [CommonModule],
  templateUrl: './circle.component.html',
  styleUrl: './circle.component.css'
})
export class CircleComponent {
  @Input({alias:'radius',required:true})
  radius:number=0;
  diameter:number=0;
  perimeter:number=0;
  area:number=0;
  flag:boolean=false
  calculate(rad:number){
    this.radius=rad? rad:this.radius;
    this.diameter=2*this.radius;
    this.perimeter=Number((Math.PI*this.diameter).toPrecision(6));
    this.area=Number((Math.PI*this.radius*this.radius).toPrecision(6));
    // this.area=Number(this.area.toPrecision(6));
    this.flag=true;
  }

}
