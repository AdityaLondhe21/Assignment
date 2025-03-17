import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankCalculatorComponent } from './bank-calculator.component';

describe('BankCalculatorComponent', () => {
  let component: BankCalculatorComponent;
  let fixture: ComponentFixture<BankCalculatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BankCalculatorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BankCalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
