package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pacient database table.
 *
 */
@Entity
@Table(name="pacient")
@NamedQuery(name="Pacient.findAll", query="SELECT p FROM Pacient p")
public class Pacient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_rojstva", nullable=false)
	private Date datumRojstva;

	@Column(nullable=false, length=64)
	private String ime;

	@Column(name="lastnik_racuna", nullable=false)
	private Integer lastnikRacuna;

	@Column(nullable=false, length=128)
	private String naslov;

	@Column(nullable=false, length=64)
	private String priimek;

	@Column(nullable=false, length=6)
	private String spol;

	@Column(name="st_kartice", nullable=false, length=32)
	private String stKartice;

	//bi-directional many-to-many association to DelovniNalog
	@ManyToMany
	@JoinTable(
		name="oskrba"
		, joinColumns={
			@JoinColumn(name="id_pacient", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_dn", nullable=false)
			}
		)
	private List<DelovniNalog> delovniNalogs;

	//bi-directional many-to-one association to Okoli
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_okolis", nullable=false)
	private Okoli okoli;

	//bi-directional many-to-one association to Posta
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_posta", nullable=false)
	private Posta posta;

	//bi-directional many-to-one association to SorodstvenaVez
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="razmerje_kontakt")
	private SorodstvenaVez sorodstvenaVez1;

	//bi-directional many-to-one association to SorodstvenaVez
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="razmerje_ur")
	private SorodstvenaVez sorodstvenaVez2;

	//bi-directional many-to-one association to UporabniškiRačun
	@ManyToOne
	@JoinColumn(name="id_racuna", nullable=false)
	private UporabniškiRačun uporabniškiRačun;

	public Pacient() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatumRojstva() {
		return this.datumRojstva;
	}

	public void setDatumRojstva(Date datumRojstva) {
		this.datumRojstva = datumRojstva;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Integer getLastnikRacuna() {
		return this.lastnikRacuna;
	}

	public void setLastnikRacuna(Integer lastnikRacuna) {
		this.lastnikRacuna = lastnikRacuna;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getPriimek() {
		return this.priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getSpol() {
		return this.spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public String getStKartice() {
		return this.stKartice;
	}

	public void setStKartice(String stKartice) {
		this.stKartice = stKartice;
	}

	public List<DelovniNalog> getDelovniNalogs() {
		return this.delovniNalogs;
	}

	public void setDelovniNalogs(List<DelovniNalog> delovniNalogs) {
		this.delovniNalogs = delovniNalogs;
	}
	
	public Okoli getOkoli() {
		return this.okoli;
	}

	public void setOkoli(Okoli okoli) {
		this.okoli = okoli;
	}

	public Posta getPosta() {
		return this.posta;
	}

	public void setPosta(Posta posta) {
		this.posta = posta;
	}

	public SorodstvenaVez getSorodstvenaVez1() {
		return this.sorodstvenaVez1;
	}

	public void setSorodstvenaVez1(SorodstvenaVez sorodstvenaVez1) {
		this.sorodstvenaVez1 = sorodstvenaVez1;
	}

	public SorodstvenaVez getSorodstvenaVez2() {
		return this.sorodstvenaVez2;
	}

	public void setSorodstvenaVez2(SorodstvenaVez sorodstvenaVez2) {
		this.sorodstvenaVez2 = sorodstvenaVez2;
	}

	public UporabniškiRačun getUporabniškiRačun() {
		return this.uporabniškiRačun;
	}

	public void setUporabniškiRačun(UporabniškiRačun uporabniškiRačun) {
		this.uporabniškiRačun = uporabniškiRačun;
	}

}
