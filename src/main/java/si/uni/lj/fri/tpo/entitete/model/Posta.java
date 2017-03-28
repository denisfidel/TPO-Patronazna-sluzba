package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the posta database table.
 * 
 */
@Entity
@Table(name="posta")
@NamedQuery(name="Posta.findAll", query="SELECT p FROM Posta p")
public class Posta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="st_poste", unique=true, nullable=false)
	private Integer stPoste;

	@Column(nullable=false, length=64)
	private String naziv;

	//bi-directional many-to-one association to IzvajalecZd
	@OneToMany(mappedBy="postaBean")
	private List<IzvajalecZd> izvajalecZds;

	//bi-directional many-to-one association to KontaktnaOseba
	@OneToMany(mappedBy="postaBean")
	private List<KontaktnaOseba> kontaktnaOsebas;

	//bi-directional many-to-one association to Pacient
	@OneToMany(mappedBy="posta")
	private List<Pacient> pacients;

	public Posta() {
	}

	public Integer getStPoste() {
		return this.stPoste;
	}

	public void setStPoste(Integer stPoste) {
		this.stPoste = stPoste;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<IzvajalecZd> getIzvajalecZds() {
		return this.izvajalecZds;
	}

	public void setIzvajalecZds(List<IzvajalecZd> izvajalecZds) {
		this.izvajalecZds = izvajalecZds;
	}

	public IzvajalecZd addIzvajalecZd(IzvajalecZd izvajalecZd) {
		getIzvajalecZds().add(izvajalecZd);
		izvajalecZd.setPostaBean(this);

		return izvajalecZd;
	}

	public IzvajalecZd removeIzvajalecZd(IzvajalecZd izvajalecZd) {
		getIzvajalecZds().remove(izvajalecZd);
		izvajalecZd.setPostaBean(null);

		return izvajalecZd;
	}

	public List<KontaktnaOseba> getKontaktnaOsebas() {
		return this.kontaktnaOsebas;
	}

	public void setKontaktnaOsebas(List<KontaktnaOseba> kontaktnaOsebas) {
		this.kontaktnaOsebas = kontaktnaOsebas;
	}

	public KontaktnaOseba addKontaktnaOseba(KontaktnaOseba kontaktnaOseba) {
		getKontaktnaOsebas().add(kontaktnaOseba);
		kontaktnaOseba.setPostaBean(this);

		return kontaktnaOseba;
	}

	public KontaktnaOseba removeKontaktnaOseba(KontaktnaOseba kontaktnaOseba) {
		getKontaktnaOsebas().remove(kontaktnaOseba);
		kontaktnaOseba.setPostaBean(null);

		return kontaktnaOseba;
	}

	public List<Pacient> getPacients() {
		return this.pacients;
	}

	public void setPacients(List<Pacient> pacients) {
		this.pacients = pacients;
	}

	public Pacient addPacient(Pacient pacient) {
		getPacients().add(pacient);
		pacient.setPosta(this);

		return pacient;
	}

	public Pacient removePacient(Pacient pacient) {
		getPacients().remove(pacient);
		pacient.setPosta(null);

		return pacient;
	}

}