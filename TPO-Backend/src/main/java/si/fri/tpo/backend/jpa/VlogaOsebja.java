package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vloga_osebja database table.
 *
 */
@Entity
@Table(name="vloga_osebja")
@NamedQuery(name="VlogaOsebja.findAll", query="SELECT v FROM VlogaOsebja v")
public class VlogaOsebja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String naziv;

	//bi-directional many-to-one association to Osebje
	@OneToMany(mappedBy="vlogaOsebja")
	private List<Osebje> osebjes;

	public VlogaOsebja() {
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

	public List<Osebje> getOsebjes() {
		return this.osebjes;
	}

	public void setOsebjes(List<Osebje> osebjes) {
		this.osebjes = osebjes;
	}

	public Osebje addOsebje(Osebje osebje) {
		getOsebjes().add(osebje);
		osebje.setVlogaOsebja(this);

		return osebje;
	}

	public Osebje removeOsebje(Osebje osebje) {
		getOsebjes().remove(osebje);
		osebje.setVlogaOsebja(null);

		return osebje;
	}

}
