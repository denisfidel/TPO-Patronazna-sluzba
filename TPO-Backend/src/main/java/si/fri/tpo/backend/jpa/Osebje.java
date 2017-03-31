package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the osebje database table.
 *
 */
@Entity
@Table(name="osebje")
@NamedQuery(name="Osebje.findAll", query="SELECT o FROM Osebje o")
public class Osebje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=64)
	private String email;

	@Column(length=128)
	private String geslo;

	@Column(nullable=false, length=64)
	private String ime;

	@Column(nullable=false)
	private Integer izbrisan;

	@Column(nullable=false, length=64)
	private String priimek;

	@Column(nullable=false, length=5)
	private String šifra;

	@Column(nullable=false, length=32)
	private String telefon;

	//bi-directional many-to-one association to DelovniNalog
	@OneToMany(mappedBy="osebje")
	private List<DelovniNalog> delovniNalogs;

	//bi-directional many-to-one association to DodeljenoOsebje
	@OneToMany(mappedBy="osebje")
	private List<DodeljenoOsebje> dodeljenoOsebjes;

	//bi-directional many-to-one association to IzvajalecZd
	@ManyToOne
	@JoinColumn(name="id_zd", nullable=false)
	private IzvajalecZd izvajalecZd;

	//bi-directional many-to-one association to Okoli
	@ManyToOne
	@JoinColumn(name="okolis")
	private Okoli okoli;

	//bi-directional many-to-one association to VlogaOsebja
	@ManyToOne
	@JoinColumn(name="id_vloga", nullable=false)
	private VlogaOsebja vlogaOsebja;

	public Osebje() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGeslo() {
		return this.geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Integer getIzbrisan() {
		return this.izbrisan;
	}

	public void setIzbrisan(Integer izbrisan) {
		this.izbrisan = izbrisan;
	}

	public String getPriimek() {
		return this.priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getŠifra() {
		return this.šifra;
	}

	public void setŠifra(String šifra) {
		this.šifra = šifra;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<DelovniNalog> getDelovniNalogs() {
		return this.delovniNalogs;
	}

	public void setDelovniNalogs(List<DelovniNalog> delovniNalogs) {
		this.delovniNalogs = delovniNalogs;
	}

	public DelovniNalog addDelovniNalog(DelovniNalog delovniNalog) {
		getDelovniNalogs().add(delovniNalog);
		delovniNalog.setOsebje(this);

		return delovniNalog;
	}

	public DelovniNalog removeDelovniNalog(DelovniNalog delovniNalog) {
		getDelovniNalogs().remove(delovniNalog);
		delovniNalog.setOsebje(null);

		return delovniNalog;
	}

	public List<DodeljenoOsebje> getDodeljenoOsebjes() {
		return this.dodeljenoOsebjes;
	}

	public void setDodeljenoOsebjes(List<DodeljenoOsebje> dodeljenoOsebjes) {
		this.dodeljenoOsebjes = dodeljenoOsebjes;
	}

	public DodeljenoOsebje addDodeljenoOsebje(DodeljenoOsebje dodeljenoOsebje) {
		getDodeljenoOsebjes().add(dodeljenoOsebje);
		dodeljenoOsebje.setOsebje(this);

		return dodeljenoOsebje;
	}

	public DodeljenoOsebje removeDodeljenoOsebje(DodeljenoOsebje dodeljenoOsebje) {
		getDodeljenoOsebjes().remove(dodeljenoOsebje);
		dodeljenoOsebje.setOsebje(null);

		return dodeljenoOsebje;
	}

	public IzvajalecZd getIzvajalecZd() {
		return this.izvajalecZd;
	}

	public void setIzvajalecZd(IzvajalecZd izvajalecZd) {
		this.izvajalecZd = izvajalecZd;
	}

	public Okoli getOkoli() {
		return this.okoli;
	}

	public void setOkoli(Okoli okoli) {
		this.okoli = okoli;
	}

	public VlogaOsebja getVlogaOsebja() {
		return this.vlogaOsebja;
	}

	public void setVlogaOsebja(VlogaOsebja vlogaOsebja) {
		this.vlogaOsebja = vlogaOsebja;
	}

}
