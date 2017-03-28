package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vrsta_podatka database table.
 * 
 */
@Entity
@Table(name="vrsta_podatka")
@NamedQuery(name="VrstaPodatka.findAll", query="SELECT v FROM VrstaPodatka v")
public class VrstaPodatka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=10)
	private String enote;

	@Column(nullable=false, length=64)
	private String naziv;

	@Column(name="podatkovni_tip", nullable=false, length=20)
	private String podatkovniTip;

	//bi-directional many-to-one association to OstaliPodatki
	@OneToMany(mappedBy="vrstaPodatka")
	private List<OstaliPodatki> ostaliPodatkis;

	public VrstaPodatka() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnote() {
		return this.enote;
	}

	public void setEnote(String enote) {
		this.enote = enote;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPodatkovniTip() {
		return this.podatkovniTip;
	}

	public void setPodatkovniTip(String podatkovniTip) {
		this.podatkovniTip = podatkovniTip;
	}

	public List<OstaliPodatki> getOstaliPodatkis() {
		return this.ostaliPodatkis;
	}

	public void setOstaliPodatkis(List<OstaliPodatki> ostaliPodatkis) {
		this.ostaliPodatkis = ostaliPodatkis;
	}

	public OstaliPodatki addOstaliPodatki(OstaliPodatki ostaliPodatki) {
		getOstaliPodatkis().add(ostaliPodatki);
		ostaliPodatki.setVrstaPodatka(this);

		return ostaliPodatki;
	}

	public OstaliPodatki removeOstaliPodatki(OstaliPodatki ostaliPodatki) {
		getOstaliPodatkis().remove(ostaliPodatki);
		ostaliPodatki.setVrstaPodatka(null);

		return ostaliPodatki;
	}

}