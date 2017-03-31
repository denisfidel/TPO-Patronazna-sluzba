package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vrsta_obiska database table.
 *
 */
@Entity
@Table(name="vrsta_obiska")
@NamedQuery(name="VrstaObiska.findAll", query="SELECT v FROM VrstaObiska v")
public class VrstaObiska implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=32)
	private String naziv;

	@Column(nullable=false)
	private Integer vrsta;

	//bi-directional many-to-one association to DelovniNalog
	@OneToMany(mappedBy="vrstaObiska")
	private List<DelovniNalog> delovniNalogs;

	//bi-directional many-to-one association to NamenObiska
	@OneToMany(mappedBy="vrstaObiska")
	private List<NamenObiska> namenObiskas;

	public VrstaObiska() {
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

	public Integer getVrsta() {
		return this.vrsta;
	}

	public void setVrsta(Integer vrsta) {
		this.vrsta = vrsta;
	}

	public List<DelovniNalog> getDelovniNalogs() {
		return this.delovniNalogs;
	}

	public void setDelovniNalogs(List<DelovniNalog> delovniNalogs) {
		this.delovniNalogs = delovniNalogs;
	}

	public DelovniNalog addDelovniNalog(DelovniNalog delovniNalog) {
		getDelovniNalogs().add(delovniNalog);
		delovniNalog.setVrstaObiska(this);

		return delovniNalog;
	}

	public DelovniNalog removeDelovniNalog(DelovniNalog delovniNalog) {
		getDelovniNalogs().remove(delovniNalog);
		delovniNalog.setVrstaObiska(null);

		return delovniNalog;
	}

	public List<NamenObiska> getNamenObiskas() {
		return this.namenObiskas;
	}

	public void setNamenObiskas(List<NamenObiska> namenObiskas) {
		this.namenObiskas = namenObiskas;
	}

	public NamenObiska addNamenObiska(NamenObiska namenObiska) {
		getNamenObiskas().add(namenObiska);
		namenObiska.setVrstaObiska(this);

		return namenObiska;
	}

	public NamenObiska removeNamenObiska(NamenObiska namenObiska) {
		getNamenObiskas().remove(namenObiska);
		namenObiska.setVrstaObiska(null);

		return namenObiska;
	}

}
