import { TestBed } from '@angular/core/testing';

import { StudiedcardService } from './studiedcard.service';

describe('StudiedcardService', () => {
  let service: StudiedcardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudiedcardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
