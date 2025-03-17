import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MutualfundCalculatorComponent } from './mutualfund-calculator.component';

describe('MutualfundCalculatorComponent', () => {
  let component: MutualfundCalculatorComponent;
  let fixture: ComponentFixture<MutualfundCalculatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MutualfundCalculatorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MutualfundCalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
