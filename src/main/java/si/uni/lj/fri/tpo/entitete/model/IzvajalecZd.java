package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the izvajalec_zd database table.
 * 
 */
@Entity
@Table(name="izvajalec_zd")
@NamedQuery(name="IzvajalecZd.findAll", query="SELECT i FROM IzvajalecZd i")
public class IzvajalecZd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String naslov;

	@Column(nullable=false, length=64)
	private String naziv;

	@Column(nullable=false, length=5)
	private String šifra;

	//bi-directional many-to-one association to Posta
	@ManyToOne
	@JoinColumn(name="posta")
	private Posta postaBean;

	//bi-directional many-to-one association to Osebje
	@OneToMany(mappedBy="izvajalecZd")
	private List<Osebje> osebjes;

	public IzvajalecZd() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
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

	public Posta getPostaBean() {
		return this.postaBean;
	}

	public void setPostaBean(Posta postaBean) {
		this.postaBean = postaBean;
	}

	public List<Osebje> getOsebjes() {
		return this.osebjes;
	}

	public void setOsebjes(List<Osebje> osebjes) {
		this.osebjes = osebjes;
	}

	public Osebje addOsebje(Osebje osebje) {
		getOsebjes().add(osebje);
		osebje.setIzvajalecZd(this);

		return osebje;
	}

	public Osebje removeOsebje(Osebje osebje) {
		getOsebjes().remove(osebje);
		osebje.setIzvajalecZd(null);

		return osebje;
	}

}