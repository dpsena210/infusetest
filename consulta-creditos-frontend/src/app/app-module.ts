import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';  // Importar aqui!

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Creditos } from './creditos/creditos';

@NgModule({
  declarations: [
    App,
    Creditos
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
