package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dodeljeno_osebje database table.
 *
 */
@Entity
@Table(name="dodeljeno_osebje")
@NamedQuery(name="DodeljenoOsebje.findAll", query="SELECT d FROM DodeljenoOsebje d")
public class DodeljenoOsebje implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="je_zadolzena", nullable=false)
	private Integer jeZadolzena;

	//bi-directional many-to-one association to Obisk
	@ManyToOne
	@JoinColumn(name="id_obisk", nullable=false)
	private Obisk obisk;

	//bi-directional many-to-one association to Osebje
	@ManyToOne
	@JoinColumn(name="id_osebja", nullable=false)
	private Osebje osebje;

	public DodeljenoOsebje() {
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJeZadolzena() {
		return this.jeZadolzena;
	}

	public void setJeZadolzena(Integer jeZadolzena) {
		this.jeZadolzena = jeZadolzena;
	}

	public Obisk getObisk() {
		return this.obisk;
	}

	public void setObisk(Obisk obisk) {
		this.obisk = obisk;
	}

	public Osebje getOsebje() {
		return this.osebje;
	}

	public void setOsebje(Osebje osebje) {
		this.osebje = osebje;
	}

}
