import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardrunnerComponent } from './card-runner.component';

describe('CardRunnerComponent', () => {
  let component: CardrunnerComponent;
  let fixture: ComponentFixture<CardrunnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardrunnerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CardrunnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
