package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status_obiska database table.
 * 
 */
@Entity
@Table(name="status_obiska")
@NamedQuery(name="StatusObiska.findAll", query="SELECT s FROM StatusObiska s")
public class StatusObiska implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String naziv;

	//bi-directional many-to-one association to Obisk
	@OneToMany(mappedBy="statusObiskaBean")
	private List<Obisk> obisks;

	public StatusObiska() {
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

	public List<Obisk> getObisks() {
		return this.obisks;
	}

	public void setObisks(List<Obisk> obisks) {
		this.obisks = obisks;
	}

	public Obisk addObisk(Obisk obisk) {
		getObisks().add(obisk);
		obisk.setStatusObiskaBean(this);

		return obisk;
	}

	public Obisk removeObisk(Obisk obisk) {
		getObisks().remove(obisk);
		obisk.setStatusObiskaBean(null);

		return obisk;
	}

}