import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersPortfolioComponent } from './users-portfolio.component';

describe('UsersPortfolioComponent', () => {
  let component: UsersPortfolioComponent;
  let fixture: ComponentFixture<UsersPortfolioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsersPortfolioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersPortfolioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
