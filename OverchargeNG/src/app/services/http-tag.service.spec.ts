import { TestBed } from '@angular/core/testing';

import { HttpTagService } from './http-tag.service';

describe('HttpTagService', () => {
  let service: HttpTagService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpTagService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
