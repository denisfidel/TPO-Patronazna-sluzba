package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aktivnosti database table.
 *
 */
@Entity
@Table(name="aktivnosti")
@NamedQuery(name="Aktivnosti.findAll", query="SELECT a FROM Aktivnosti a")
public class Aktivnosti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String aktivnost;

	@Column(nullable=false, length=32)
	private String sifra;

	//bi-directional many-to-one association to OstaliPodatki
	@OneToMany(mappedBy="aktivnosti")
	private List<OstaliPodatki> ostaliPodatkis;

	public Aktivnosti() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAktivnost() {
		return this.aktivnost;
	}

	public void setAktivnost(String aktivnost) {
		this.aktivnost = aktivnost;
	}

	public String getSifra() {
		return this.sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public List<OstaliPodatki> getOstaliPodatkis() {
		return this.ostaliPodatkis;
	}

	public void setOstaliPodatkis(List<OstaliPodatki> ostaliPodatkis) {
		this.ostaliPodatkis = ostaliPodatkis;
	}

	public OstaliPodatki addOstaliPodatki(OstaliPodatki ostaliPodatki) {
		getOstaliPodatkis().add(ostaliPodatki);
		ostaliPodatki.setAktivnosti(this);

		return ostaliPodatki;
	}

	public OstaliPodatki removeOstaliPodatki(OstaliPodatki ostaliPodatki) {
		getOstaliPodatkis().remove(ostaliPodatki);
		ostaliPodatki.setAktivnosti(null);

		return ostaliPodatki;
	}

}
