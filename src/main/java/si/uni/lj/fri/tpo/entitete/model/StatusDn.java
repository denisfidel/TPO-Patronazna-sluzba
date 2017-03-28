package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status_dn database table.
 * 
 */
@Entity
@Table(name="status_dn")
@NamedQuery(name="StatusDn.findAll", query="SELECT s FROM StatusDn s")
public class StatusDn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=32)
	private String naziv;

	//bi-directional many-to-one association to DelovniNalog
	@OneToMany(mappedBy="statusDnBean")
	private List<DelovniNalog> delovniNalogs;

	public StatusDn() {
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

	public List<DelovniNalog> getDelovniNalogs() {
		return this.delovniNalogs;
	}

	public void setDelovniNalogs(List<DelovniNalog> delovniNalogs) {
		this.delovniNalogs = delovniNalogs;
	}

	public DelovniNalog addDelovniNalog(DelovniNalog delovniNalog) {
		getDelovniNalogs().add(delovniNalog);
		delovniNalog.setStatusDnBean(this);

		return delovniNalog;
	}

	public DelovniNalog removeDelovniNalog(DelovniNalog delovniNalog) {
		getDelovniNalogs().remove(delovniNalog);
		delovniNalog.setStatusDnBean(null);

		return delovniNalog;
	}

}