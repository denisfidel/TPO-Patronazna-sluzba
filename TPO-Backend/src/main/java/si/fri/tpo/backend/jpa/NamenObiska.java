package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the namen_obiska database table.
 *
 */
@Entity
@Table(name="namen_obiska")
@NamedQuery(name="NamenObiska.findAll", query="SELECT n FROM NamenObiska n")
public class NamenObiska implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=64)
	private String naziv;

	//bi-directional many-to-one association to VrstaObiska
	@ManyToOne
	@JoinColumn(name="id_vrsta", nullable=false)
	private VrstaObiska vrstaObiska;

	public NamenObiska() {
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

	public VrstaObiska getVrstaObiska() {
		return this.vrstaObiska;
	}

	public void setVrstaObiska(VrstaObiska vrstaObiska) {
		this.vrstaObiska = vrstaObiska;
	}

}
