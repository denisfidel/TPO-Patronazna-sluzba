package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ljudje database table.
 *
 */
@Entity
@Table(name="ljudje")
@NamedQuery(name="Ljudje.findAll", query="SELECT l FROM Ljudje l")
public class Ljudje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=30)
	private String ime;

	@Column(nullable=false, length=30)
	private String priimek;

	public Ljudje() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return this.priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

}
