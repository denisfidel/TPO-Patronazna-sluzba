package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the odvzem_krvi database table.
 * 
 */
@Entity
@Table(name="odvzem_krvi")
@NamedQuery(name="OdvzemKrvi.findAll", query="SELECT o FROM OdvzemKrvi o")
public class OdvzemKrvi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="st_epruvet", nullable=false)
	private Integer stEpruvet;

	//bi-directional many-to-one association to BarvaEpruvete
	@ManyToOne
	@JoinColumn(name="barva", nullable=false)
	private BarvaEpruvete barvaEpruvete;

	//bi-directional many-to-one association to Obisk
	@ManyToOne
	@JoinColumn(name="id_obisk")
	private Obisk obisk;

	public OdvzemKrvi() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStEpruvet() {
		return this.stEpruvet;
	}

	public void setStEpruvet(Integer stEpruvet) {
		this.stEpruvet = stEpruvet;
	}

	public BarvaEpruvete getBarvaEpruvete() {
		return this.barvaEpruvete;
	}

	public void setBarvaEpruvete(BarvaEpruvete barvaEpruvete) {
		this.barvaEpruvete = barvaEpruvete;
	}

	public Obisk getObisk() {
		return this.obisk;
	}

	public void setObisk(Obisk obisk) {
		this.obisk = obisk;
	}

}