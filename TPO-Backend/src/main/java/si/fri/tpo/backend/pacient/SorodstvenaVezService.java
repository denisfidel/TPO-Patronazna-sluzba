package si.fri.tpo.backend.pacient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import si.fri.tpo.backend.jpa.SorodstvenaVez;
import si.fri.tpo.backend.rest.SorodstvenaVezRepository;

@Service
public class SorodstvenaVezService {
	@Autowired
	SorodstvenaVezRepository svr;
	
	public List<SorodstvenaVez> getAllSorodstvenaVez(){
		return svr.findAll();
	}
}
