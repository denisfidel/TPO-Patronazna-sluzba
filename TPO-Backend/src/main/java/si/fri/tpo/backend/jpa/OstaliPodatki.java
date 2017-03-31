package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ostali_podatki database table.
 *
 */
@Entity
@Table(name="ostali_podatki")
@NamedQuery(name="OstaliPodatki.findAll", query="SELECT o FROM OstaliPodatki o")
public class OstaliPodatki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Integer obvezen;

	@Column(nullable=false, length=256)
	private String vrednost;

	//bi-directional many-to-one association to Aktivnosti
	@ManyToOne
	@JoinColumn(name="id_aktivnosti", nullable=false)
	private Aktivnosti aktivnosti;

	//bi-directional many-to-one association to Obisk
	@ManyToOne
	@JoinColumn(name="id_obisk", nullable=false)
	private Obisk obisk;

	//bi-directional many-to-one association to VrstaPodatka
	@ManyToOne
	@JoinColumn(name="id_vrsta_podatka", nullable=false)
	private VrstaPodatka vrstaPodatka;

	public OstaliPodatki() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getObvezen() {
		return this.obvezen;
	}

	public void setObvezen(Integer obvezen) {
		this.obvezen = obvezen;
	}

	public String getVrednost() {
		return this.vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}

	public Aktivnosti getAktivnosti() {
		return this.aktivnosti;
	}

	public void setAktivnosti(Aktivnosti aktivnosti) {
		this.aktivnosti = aktivnosti;
	}

	public Obisk getObisk() {
		return this.obisk;
	}

	public void setObisk(Obisk obisk) {
		this.obisk = obisk;
	}

	public VrstaPodatka getVrstaPodatka() {
		return this.vrstaPodatka;
	}

	public void setVrstaPodatka(VrstaPodatka vrstaPodatka) {
		this.vrstaPodatka = vrstaPodatka;
	}

}
