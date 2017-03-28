package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the injekcije database table.
 * 
 */
@Entity
@Table(name="injekcije")
@NamedQuery(name="Injekcije.findAll", query="SELECT i FROM Injekcije i")
public class Injekcije implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="st_injekcij")
	private Integer stInjekcij;

	//bi-directional many-to-one association to Obisk
	@ManyToOne
	@JoinColumn(name="id_obisk", nullable=false)
	private Obisk obisk;

	//bi-directional many-to-one association to Zdravila
	@ManyToOne
	@JoinColumn(name="id_zdravilo", nullable=false)
	private Zdravila zdravila;

	public Injekcije() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStInjekcij() {
		return this.stInjekcij;
	}

	public void setStInjekcij(Integer stInjekcij) {
		this.stInjekcij = stInjekcij;
	}

	public Obisk getObisk() {
		return this.obisk;
	}

	public void setObisk(Obisk obisk) {
		this.obisk = obisk;
	}

	public Zdravila getZdravila() {
		return this.zdravila;
	}

	public void setZdravila(Zdravila zdravila) {
		this.zdravila = zdravila;
	}

}