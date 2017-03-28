package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vrsta_storitve database table.
 * 
 */
@Entity
@Table(name="vrsta_storitve")
@NamedQuery(name="VrstaStoritve.findAll", query="SELECT v FROM VrstaStoritve v")
public class VrstaStoritve implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String naziv;

	@Column(nullable=false, length=10)
	private String sifra;

	//bi-directional many-to-one association to DelovniNalog
	@OneToMany(mappedBy="vrstaStoritveBean")
	private List<DelovniNalog> delovniNalogs;

	public VrstaStoritve() {
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

	public String getSifra() {
		return this.sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public List<DelovniNalog> getDelovniNalogs() {
		return this.delovniNalogs;
	}

	public void setDelovniNalogs(List<DelovniNalog> delovniNalogs) {
		this.delovniNalogs = delovniNalogs;
	}

	public DelovniNalog addDelovniNalog(DelovniNalog delovniNalog) {
		getDelovniNalogs().add(delovniNalog);
		delovniNalog.setVrstaStoritveBean(this);

		return delovniNalog;
	}

	public DelovniNalog removeDelovniNalog(DelovniNalog delovniNalog) {
		getDelovniNalogs().remove(delovniNalog);
		delovniNalog.setVrstaStoritveBean(null);

		return delovniNalog;
	}

}