package si.fri.tpo.backend.pacient;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import si.fri.tpo.backend.jpa.CrnaLista;
import si.fri.tpo.backend.jpa.DelovniNalog;
import si.fri.tpo.backend.jpa.Okoli;
import si.fri.tpo.backend.jpa.Pacient;
import si.fri.tpo.backend.jpa.Posta;
import si.fri.tpo.backend.jpa.SorodstvenaVez;
import si.fri.tpo.backend.jpa.StatusUr;
import si.fri.tpo.backend.jpa.UporabniškiRačun;

public class Uporabnik {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String geslo;
	private String telefon;
	private List<CrnaLista> crnaListas;
	private List<Pacient> pacients;
	private StatusUr statusUr;
	private Date datumRojstva;
	private String ime;
	private String naslov;
	private String priimek;
	private String spol;
	private String stKartice;
	private List<DelovniNalog> delovniNalogs;
	private Okoli okoli;

	private int posta;

	private SorodstvenaVez sorodstvenaVez1;//razmerje za kontakt
	private SorodstvenaVez sorodstvenaVez2;

	public Uporabnik () {
	}



	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGeslo() {
		return this.geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<CrnaLista> getCrnaListas() {
		return this.crnaListas;
	}

	public void setCrnaListas(List<CrnaLista> crnaListas) {
		this.crnaListas = crnaListas;
	}


	public List<Pacient> getPacients() {
		return this.pacients;
	}

	public void setPacients(List<Pacient> pacients) {
		this.pacients = pacients;
	}


	public Pacient removePacient(Pacient pacient) {
		getPacients().remove(pacient);
		pacient.setUporabniškiRačun(null);

		return pacient;
	}

	public StatusUr getStatusUr() {
		return this.statusUr;
	}

	public void setStatusUr(StatusUr statusUr) {
		this.statusUr = statusUr;
	}

	


	public Date getDatumRojstva() {
		return this.datumRojstva;
	}

	public void setDatumRojstva(Date datumRojstva) {
		this.datumRojstva = datumRojstva;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getPriimek() {
		return this.priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getSpol() {
		return this.spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public String getStKartice() {
		return this.stKartice;
	}

	public void setStKartice(String stKartice) {
		this.stKartice = stKartice;
	}

	public List<DelovniNalog> getDelovniNalogs() {
		return this.delovniNalogs;
	}

	public void setDelovniNalogs(List<DelovniNalog> delovniNalogs) {
		this.delovniNalogs = delovniNalogs;
	}

	public Okoli getOkoli() {
		return this.okoli;
	}

	public void setOkoli(Okoli okoli) {
		this.okoli = okoli;
	}

	public int getPosta() {
		return this.posta;
	}

	public void setPosta(int posta) {
		this.posta = posta;
	}

	public SorodstvenaVez getSorodstvenaVez1() {
		return this.sorodstvenaVez1;
	}

	public void setSorodstvenaVez1(SorodstvenaVez sorodstvenaVez1) {
		this.sorodstvenaVez1 = sorodstvenaVez1;
	}

	public SorodstvenaVez getSorodstvenaVez2() {
		return this.sorodstvenaVez2;
	}

	public void setSorodstvenaVez2(SorodstvenaVez sorodstvenaVez2) {
		this.sorodstvenaVez2 = sorodstvenaVez2;
	}

}
