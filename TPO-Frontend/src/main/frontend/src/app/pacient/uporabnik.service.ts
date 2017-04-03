import { Pacient } from './pacient';
import { SorodstvenaVez } from './sorodstvenavez';
import { Uporabnik } from './uporabnik';
import {Injectable}    from '@angular/core';
import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {UporabniskiRacun} from './uporabniskiRacun';

@Injectable()
export class UporabnikService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private url = 'http://localhost:8080';

  constructor(private http: Http) {
  }
  getSorodstvenaVez(): Promise<SorodstvenaVez[]>{
    const url = `${this.url}/sorodstvenaVez`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as SorodstvenaVez[])
      .catch(this.handleError);
  }
  
  saveUporabniskiRacun(uporabnik: Uporabnik): Promise<any> {
    const url = `${this.url}/uporabniskiRacun`;
    return this.http
      .post(url, JSON.stringify(uporabnik), {headers: this.headers})
      .toPromise()
      .then()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Prišlo je do napake', error);
    return Promise.reject(error.message || error);
  }
}
