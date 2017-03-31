package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the zdravila database table.
 *
 */
@Entity
@Table(name="zdravila")
@NamedQuery(name="Zdravila.findAll", query="SELECT z FROM Zdravila z")
public class Zdravila implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, precision=6, scale=2)
	private BigDecimal cena;

	@Column(nullable=false, length=64)
	private String naziv;

	//bi-directional many-to-one association to Injekcije
	@OneToMany(mappedBy="zdravila")
	private List<Injekcije> injekcijes;

	public Zdravila() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCena() {
		return this.cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Injekcije> getInjekcijes() {
		return this.injekcijes;
	}

	public void setInjekcijes(List<Injekcije> injekcijes) {
		this.injekcijes = injekcijes;
	}

	public Injekcije addInjekcije(Injekcije injekcije) {
		getInjekcijes().add(injekcije);
		injekcije.setZdravila(this);

		return injekcije;
	}

	public Injekcije removeInjekcije(Injekcije injekcije) {
		getInjekcijes().remove(injekcije);
		injekcije.setZdravila(null);

		return injekcije;
	}

}
