import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RaiseQuestionComponent } from './raise-question.component';

describe('RaiseQuestionComponent', () => {
  let component: RaiseQuestionComponent;
  let fixture: ComponentFixture<RaiseQuestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RaiseQuestionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RaiseQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
