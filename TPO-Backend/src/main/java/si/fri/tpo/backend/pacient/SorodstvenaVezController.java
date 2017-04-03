package si.fri.tpo.backend.pacient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import si.fri.tpo.backend.jpa.SorodstvenaVez;

@CrossOrigin
@RestController
public class SorodstvenaVezController {

	@Autowired
	SorodstvenaVezService svs;
	
	@RequestMapping("/sorodstvenaVez")
	public List<SorodstvenaVez> getAllSorodstvenaVez(){
		return svs.getAllSorodstvenaVez();
	}
}
