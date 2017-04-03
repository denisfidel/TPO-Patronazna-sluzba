import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule}    from '@angular/http';
import {FormsModule}   from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';

import {AppComponent}         from './app.component';
import {UporabniskiRacunDodajComponent}      from './pacient/uporabniskiRacun-dodaj.component';
import {UporabnikService} from './pacient/uporabnik.service';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule,
    FormsModule
  ],
  declarations: [
    AppComponent,
    UporabniskiRacunDodajComponent,
  ],
  providers: [UporabnikService],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
