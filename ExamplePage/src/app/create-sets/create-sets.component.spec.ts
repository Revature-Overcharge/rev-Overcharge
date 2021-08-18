import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSetsComponent } from './create-sets.component';

describe('CreateSetsComponent', () => {
  let component: CreateSetsComponent;
  let fixture: ComponentFixture<CreateSetsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateSetsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
