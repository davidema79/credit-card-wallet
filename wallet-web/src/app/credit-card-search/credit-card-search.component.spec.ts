import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditCardSearchComponent } from './credit-card-search.component';

describe('CreditCardSearchComponent', () => {
  let component: CreditCardSearchComponent;
  let fixture: ComponentFixture<CreditCardSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreditCardSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditCardSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
