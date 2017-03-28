package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the barva_epruvete database table.
 * 
 */
@Entity
@Table(name="barva_epruvete")
@NamedQuery(name="BarvaEpruvete.findAll", query="SELECT b FROM BarvaEpruvete b")
public class BarvaEpruvete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=20)
	private String barva;

	//bi-directional many-to-one association to OdvzemKrvi
	@OneToMany(mappedBy="barvaEpruvete")
	private List<OdvzemKrvi> odvzemKrvis;

	public BarvaEpruvete() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarva() {
		return this.barva;
	}

	public void setBarva(String barva) {
		this.barva = barva;
	}

	public List<OdvzemKrvi> getOdvzemKrvis() {
		return this.odvzemKrvis;
	}

	public void setOdvzemKrvis(List<OdvzemKrvi> odvzemKrvis) {
		this.odvzemKrvis = odvzemKrvis;
	}

	public OdvzemKrvi addOdvzemKrvi(OdvzemKrvi odvzemKrvi) {
		getOdvzemKrvis().add(odvzemKrvi);
		odvzemKrvi.setBarvaEpruvete(this);

		return odvzemKrvi;
	}

	public OdvzemKrvi removeOdvzemKrvi(OdvzemKrvi odvzemKrvi) {
		getOdvzemKrvis().remove(odvzemKrvi);
		odvzemKrvi.setBarvaEpruvete(null);

		return odvzemKrvi;
	}

}