package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the uporabniški_račun database table.
 *
 */
@Entity
@Table(name="uporabniški_račun")
@NamedQuery(name="UporabniškiRačun.findAll", query="SELECT u FROM UporabniškiRačun u")
public class UporabniškiRačun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable=false, length=64)
	private String email;

	@Column(nullable=false, length=128)
	private String geslo;

	@Column(nullable=false, length=64)
	private String telefon;

	//bi-directional many-to-one association to CrnaLista
	@OneToMany(mappedBy="uporabniškiRačun")
	private List<CrnaLista> crnaListas;

	//bi-directional many-to-one association to Pacient
	@OneToMany(mappedBy="uporabniškiRačun")
	private List<Pacient> pacients;

	//bi-directional many-to-one association to StatusUr
	@ManyToOne
	@JoinColumn(name="id_status", nullable=false)
	private StatusUr statusUr;

	public UporabniškiRačun() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public CrnaLista addCrnaLista(CrnaLista crnaLista) {
		getCrnaListas().add(crnaLista);
		crnaLista.setUporabniškiRačun(this);

		return crnaLista;
	}

	public CrnaLista removeCrnaLista(CrnaLista crnaLista) {
		getCrnaListas().remove(crnaLista);
		crnaLista.setUporabniškiRačun(null);

		return crnaLista;
	}

	public List<Pacient> getPacients() {
		return this.pacients;
	}

	public void setPacients(List<Pacient> pacients) {
		this.pacients = pacients;
	}

	public Pacient addPacient(Pacient pacient) {
		getPacients().add(pacient);
		pacient.setUporabniškiRačun(this);

		return pacient;
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

}
