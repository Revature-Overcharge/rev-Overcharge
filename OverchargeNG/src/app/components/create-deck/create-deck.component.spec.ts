import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDeckComponent } from './create-deck.component';

describe('CreateDeckComponent', () => {
  let component: CreateDeckComponent;
  let fixture: ComponentFixture<CreateDeckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateDeckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateDeckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
