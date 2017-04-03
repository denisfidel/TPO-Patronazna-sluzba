import {NgModule}             from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {UporabniskiRacunDodajComponent}  from './pacient/uporabniskiRacun-dodaj.component';
import {AppComponent} from './app.component';

const routes: Routes = [
  //{path: '', component: AppComponent},
  {path: 'registracija', component: UporabniskiRacunDodajComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
