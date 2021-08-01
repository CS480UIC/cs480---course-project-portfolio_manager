import { TestBed } from '@angular/core/testing';

import { PortfolioServiceService } from './portfolio-service.service';

describe('PortfolioServiceService', () => {
  let service: PortfolioServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PortfolioServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
