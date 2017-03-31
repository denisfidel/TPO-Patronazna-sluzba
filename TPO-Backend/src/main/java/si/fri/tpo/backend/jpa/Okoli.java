package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the okolis database table.
 *
 */
@Entity
@Table(name="okolis")
@NamedQuery(name="Okoli.findAll", query="SELECT o FROM Okoli o")
public class Okoli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String naziv;

	@Column(nullable=false, length=32)
	private String šifra;

	//bi-directional many-to-one association to Osebje
	@OneToMany(mappedBy="okoli")
	private List<Osebje> osebjes;

	//bi-directional many-to-one association to Pacient
	@OneToMany(mappedBy="okoli")
	private List<Pacient> pacients;

	public Okoli() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getŠifra() {
		return this.šifra;
	}

	public void setŠifra(String šifra) {
		this.šifra = šifra;
	}

	public List<Osebje> getOsebjes() {
		return this.osebjes;
	}

	public void setOsebjes(List<Osebje> osebjes) {
		this.osebjes = osebjes;
	}

	public Osebje addOsebje(Osebje osebje) {
		getOsebjes().add(osebje);
		osebje.setOkoli(this);

		return osebje;
	}

	public Osebje removeOsebje(Osebje osebje) {
		getOsebjes().remove(osebje);
		osebje.setOkoli(null);

		return osebje;
	}

	public List<Pacient> getPacients() {
		return this.pacients;
	}

	public void setPacients(List<Pacient> pacients) {
		this.pacients = pacients;
	}

	public Pacient addPacient(Pacient pacient) {
		getPacients().add(pacient);
		pacient.setOkoli(this);

		return pacient;
	}

	public Pacient removePacient(Pacient pacient) {
		getPacients().remove(pacient);
		pacient.setOkoli(null);

		return pacient;
	}

}
