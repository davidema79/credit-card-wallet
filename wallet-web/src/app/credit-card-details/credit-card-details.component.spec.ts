import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditCardDetailsComponent } from './credit-card-details.component';

describe('CreditCardDetailsComponent', () => {
  let component: CreditCardDetailsComponent;
  let fixture: ComponentFixture<CreditCardDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreditCardDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditCardDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
