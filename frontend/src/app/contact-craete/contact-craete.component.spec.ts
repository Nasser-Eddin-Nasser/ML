import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactCraeteComponent } from './contact-craete.component';

describe('ContactCraeteComponent', () => {
  let component: ContactCraeteComponent;
  let fixture: ComponentFixture<ContactCraeteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContactCraeteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactCraeteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
