package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status_ur database table.
 * 
 */
@Entity
@Table(name="status_ur")
@NamedQuery(name="StatusUr.findAll", query="SELECT s FROM StatusUr s")
public class StatusUr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String naziv;

	//bi-directional many-to-one association to UporabniškiRačun
	@OneToMany(mappedBy="statusUr")
	private List<UporabniškiRačun> uporabniškiRačuns;

	public StatusUr() {
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

	public List<UporabniškiRačun> getUporabniškiRačuns() {
		return this.uporabniškiRačuns;
	}

	public void setUporabniškiRačuns(List<UporabniškiRačun> uporabniškiRačuns) {
		this.uporabniškiRačuns = uporabniškiRačuns;
	}

	public UporabniškiRačun addUporabniškiRačun(UporabniškiRačun uporabniškiRačun) {
		getUporabniškiRačuns().add(uporabniškiRačun);
		uporabniškiRačun.setStatusUr(this);

		return uporabniškiRačun;
	}

	public UporabniškiRačun removeUporabniškiRačun(UporabniškiRačun uporabniškiRačun) {
		getUporabniškiRačuns().remove(uporabniškiRačun);
		uporabniškiRačun.setStatusUr(null);

		return uporabniškiRačun;
	}

}