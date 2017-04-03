package si.fri.tpo.backend.pacient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import si.fri.tpo.backend.jpa.Pacient;
import si.fri.tpo.backend.jpa.UporabniškiRačun;

@CrossOrigin
@RestController
public class PacientController {
	
	@Autowired
	PacientService ps;
	
	@RequestMapping(method=RequestMethod.POST, value="/pacient")
	public void savePacient(Pacient pacient){
		ps.addPacient(pacient);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/uporabniskiRacun")
	public void saveUporabniskiPacient(@RequestBody Uporabnik uporabnik){
		ps.addPacientAndUporabniski(uporabnik);
	}
	
	@RequestMapping("/uporabniskiRacun")
	public List<UporabniškiRačun> getAllUporabniskiRacun(){
		return ps.getAllUporabniskiRacun();
	}
	
	@RequestMapping("/uporabniskiRacun/{id}")
	public UporabniškiRačun getUporabniskiRacun(@PathVariable int id){
		return ps.getUporabniskiRacun(id);
	}
	
	@RequestMapping("/pacient")
	public List<UporabniškiRačun> getAllPacient(){
		return ps.getAllUporabniskiRacun();
	}
	
	@RequestMapping("/pacient/{id}")
	public UporabniškiRačun getPacient(@PathVariable int id){
		return ps.getUporabniskiRacun(id);
	}
}
