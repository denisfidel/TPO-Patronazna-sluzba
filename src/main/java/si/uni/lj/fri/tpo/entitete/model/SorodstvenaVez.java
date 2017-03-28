package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sorodstvena_vez database table.
 * 
 */
@Entity
@Table(name="sorodstvena_vez")
@NamedQuery(name="SorodstvenaVez.findAll", query="SELECT s FROM SorodstvenaVez s")
public class SorodstvenaVez implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String naziv;

	//bi-directional many-to-one association to Pacient
	@OneToMany(mappedBy="sorodstvenaVez1")
	private List<Pacient> pacients1;

	//bi-directional many-to-one association to Pacient
	@OneToMany(mappedBy="sorodstvenaVez2")
	private List<Pacient> pacients2;

	public SorodstvenaVez() {
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

	public List<Pacient> getPacients1() {
		return this.pacients1;
	}

	public void setPacients1(List<Pacient> pacients1) {
		this.pacients1 = pacients1;
	}

	public Pacient addPacients1(Pacient pacients1) {
		getPacients1().add(pacients1);
		pacients1.setSorodstvenaVez1(this);

		return pacients1;
	}

	public Pacient removePacients1(Pacient pacients1) {
		getPacients1().remove(pacients1);
		pacients1.setSorodstvenaVez1(null);

		return pacients1;
	}

	public List<Pacient> getPacients2() {
		return this.pacients2;
	}

	public void setPacients2(List<Pacient> pacients2) {
		this.pacients2 = pacients2;
	}

	public Pacient addPacients2(Pacient pacients2) {
		getPacients2().add(pacients2);
		pacients2.setSorodstvenaVez2(this);

		return pacients2;
	}

	public Pacient removePacients2(Pacient pacients2) {
		getPacients2().remove(pacients2);
		pacients2.setSorodstvenaVez2(null);

		return pacients2;
	}

}