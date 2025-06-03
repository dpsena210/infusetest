import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Creditos } from './creditos';

describe('Creditos', () => {
  let component: Creditos;
  let fixture: ComponentFixture<Creditos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Creditos]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Creditos);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
