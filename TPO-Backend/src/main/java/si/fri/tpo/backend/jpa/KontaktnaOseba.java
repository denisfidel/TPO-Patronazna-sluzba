package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kontaktna_oseba database table.
 *
 */
@Entity
@Table(name="kontaktna_oseba")
@NamedQuery(name="KontaktnaOseba.findAll", query="SELECT k FROM KontaktnaOseba k")
public class KontaktnaOseba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String ime;

	@Column(nullable=false, length=128)
	private String naslov;

	@Column(nullable=false, length=64)
	private String priimek;

	@Column(nullable=false, length=64)
	private String telefon;

	//bi-directional many-to-one association to Posta
	@ManyToOne
	@JoinColumn(name="posta", nullable=false)
	private Posta postaBean;

	public KontaktnaOseba() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Posta getPostaBean() {
		return this.postaBean;
	}

	public void setPostaBean(Posta postaBean) {
		this.postaBean = postaBean;
	}

}
