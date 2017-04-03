import {Component, OnInit} from '@angular/core';
import {Router}            from '@angular/router';

import {UporabniskiRacun} from './uporabniskiRacun';
import {Pacient} from './pacient';
import {Kontakt} from './kontakt';
import { SorodstvenaVez } from './sorodstvenavez';
import { Uporabnik } from './uporabnik';
import {UporabnikService} from './uporabnik.service';

@Component({
	moduleId: module.id,
	selector: 'dodaj-uporabniski',
	templateUrl: 'uporabniskiRacun-dodaj.component.html',
})

export class UporabniskiRacunDodajComponent{
	uporabnik: Uporabnik = new Uporabnik;
	kontakt: Kontakt = null;
  vezi: SorodstvenaVez[];
  niDodan = true;

	constructor(private uporabnikService: UporabnikService,
              private router: Router) {
  }

	submitForm(): void {
		console.log(this.uporabnik);
		if(this.kontakt != null){
			console.log(this.kontakt);
		}
		this.uporabnikService
		  .saveUporabniskiRacun(this.uporabnik)
		  .then( () => {
			this.router.navigate(['/']);
		  });
	}
	
	dodajKontaktnoOsebo(): void{
		this.kontakt = new Kontakt;
    this.uporabnikService
      .getSorodstvenaVez()
      .then(vezi => this.vezi = vezi);
    this.niDodan = false;
    console.log(this.vezi)
	}
	
	odstarniKOntaktnoOsebo(): void{
    this.kontakt = null;
    this.niDodan = true;
	}
}
