package si.fri.tpo.backend.pacient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import si.fri.tpo.backend.jpa.Okoli;
import si.fri.tpo.backend.jpa.Pacient;
import si.fri.tpo.backend.jpa.Posta;
import si.fri.tpo.backend.jpa.StatusUr;
import si.fri.tpo.backend.jpa.UporabniškiRačun;
import si.fri.tpo.backend.rest.PacientRepository;
import si.fri.tpo.backend.rest.PostaRepository;
import si.fri.tpo.backend.rest.StatusUrRepository;
import si.fri.tpo.backend.rest.UporabniškiRačunRepository;

@Service
public class PacientService {
	
	@Autowired
	PacientRepository pr;
	@Autowired
	UporabniškiRačunRepository urr;
	@Autowired
	StatusUrRepository sur;
	@Autowired
	PostaRepository postaRep;
	
	public int addPacient (Pacient pacient){
		Pacient p = pr.saveAndFlush(pacient);
		return p.getId();
	}
	
	public int addUporabniskiRacun(UporabniškiRačun ur){
		UporabniškiRačun uporabniski = urr.saveAndFlush(ur);
		return uporabniski.getId();
	}
	
	public void addPacientAndUporabniski(Uporabnik uporabnik){
		Pacient pacient = new Pacient();
		UporabniškiRačun ur = new UporabniškiRačun();
		
		pacient.setIme(uporabnik.getIme());
		pacient.setPriimek(uporabnik.getPriimek());
		pacient.setNaslov(uporabnik.getNaslov());
		pacient.setDatumRojstva(uporabnik.getDatumRojstva());
		Posta posta = postaRep.getOne(uporabnik.getPosta());
		pacient.setPosta(posta);
		pacient.setSpol(uporabnik.getSpol());
		pacient.setStKartice(uporabnik.getStKartice());
		Okoli okolis = new Okoli();
		okolis.setId(1);
		okolis.setNaziv("Ljubljana-Center");
		pacient.setOkoli(okolis);
		pacient.setLastnikRacuna(0);
		
		ur.setEmail(uporabnik.getEmail());
		ur.setGeslo(uporabnik.getGeslo());
		ur.setTelefon(uporabnik.getTelefon());
		StatusUr status = sur.getOne(1);
		ur.setStatusUr(status);
	
		
		List<Pacient> pacients = new ArrayList<Pacient>();
		ur.setPacients(pacients);
		int u = addUporabniskiRacun(ur);
		pacient.setUporabniškiRačun(ur);
		int i = addPacient(pacient);
		ur.addPacient(pacient);
		u = addUporabniskiRacun(ur);
		
	}
	
	public List<UporabniškiRačun> getAllUporabniskiRacun(){
		return urr.findAll();
	}
	
	public List<Pacient> getAllPacient(){
		return pr.findAll();
	}
	
	public Pacient getPacient(int id){
		return pr.getOne(id);
	}
	
	public UporabniškiRačun getUporabniskiRacun(int id){
		return urr.getOne(id);
	}
	
}
