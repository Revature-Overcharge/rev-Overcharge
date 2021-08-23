import { TestBed } from '@angular/core/testing';

import { HttpDeckService } from './http-deck.service';

describe('HttpDeckService', () => {
  let service: HttpDeckService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpDeckService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
