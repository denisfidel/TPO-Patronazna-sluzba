package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the obisk database table.
 *
 */
@Entity
@Table(name="obisk")
@NamedQuery(name="Obisk.findAll", query="SELECT o FROM Obisk o")
public class Obisk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(precision=6, scale=2)
	private BigDecimal cena;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_obiska")
	private Date datumObiska;

	@Temporal(TemporalType.DATE)
	@Column(name="izbran_datum")
	private Date izbranDatum;

	@Column(name="podrobnosti_obiska", length=2147483647)
	private String podrobnostiObiska;

	@Temporal(TemporalType.DATE)
	@Column(name="predviden_datum")
	private Date predvidenDatum;

	@Column(name="zaporedna_st_obiska", nullable=false)
	private Integer zaporednaStObiska;

	//bi-directional many-to-one association to DodeljenoOsebje
	@OneToMany(mappedBy="obisk")
	private List<DodeljenoOsebje> dodeljenoOsebjes;

	//bi-directional many-to-one association to Injekcije
	@OneToMany(mappedBy="obisk")
	private List<Injekcije> injekcijes;

	//bi-directional many-to-one association to DelovniNalog
	@ManyToOne
	@JoinColumn(name="id_dn", nullable=false)
	private DelovniNalog delovniNalog;

	//bi-directional many-to-one association to StatusObiska
	@ManyToOne
	@JoinColumn(name="status_obiska", nullable=false)
	private StatusObiska statusObiskaBean;

	//bi-directional many-to-one association to OdvzemKrvi
	@OneToMany(mappedBy="obisk")
	private List<OdvzemKrvi> odvzemKrvis;

	//bi-directional many-to-one association to OstaliPodatki
	@OneToMany(mappedBy="obisk")
	private List<OstaliPodatki> ostaliPodatkis;

	public Obisk() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCena() {
		return this.cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public Date getDatumObiska() {
		return this.datumObiska;
	}

	public void setDatumObiska(Date datumObiska) {
		this.datumObiska = datumObiska;
	}

	public Date getIzbranDatum() {
		return this.izbranDatum;
	}

	public void setIzbranDatum(Date izbranDatum) {
		this.izbranDatum = izbranDatum;
	}

	public String getPodrobnostiObiska() {
		return this.podrobnostiObiska;
	}

	public void setPodrobnostiObiska(String podrobnostiObiska) {
		this.podrobnostiObiska = podrobnostiObiska;
	}

	public Date getPredvidenDatum() {
		return this.predvidenDatum;
	}

	public void setPredvidenDatum(Date predvidenDatum) {
		this.predvidenDatum = predvidenDatum;
	}

	public Integer getZaporednaStObiska() {
		return this.zaporednaStObiska;
	}

	public void setZaporednaStObiska(Integer zaporednaStObiska) {
		this.zaporednaStObiska = zaporednaStObiska;
	}

	public List<DodeljenoOsebje> getDodeljenoOsebjes() {
		return this.dodeljenoOsebjes;
	}

	public void setDodeljenoOsebjes(List<DodeljenoOsebje> dodeljenoOsebjes) {
		this.dodeljenoOsebjes = dodeljenoOsebjes;
	}

	public DodeljenoOsebje addDodeljenoOsebje(DodeljenoOsebje dodeljenoOsebje) {
		getDodeljenoOsebjes().add(dodeljenoOsebje);
		dodeljenoOsebje.setObisk(this);

		return dodeljenoOsebje;
	}

	public DodeljenoOsebje removeDodeljenoOsebje(DodeljenoOsebje dodeljenoOsebje) {
		getDodeljenoOsebjes().remove(dodeljenoOsebje);
		dodeljenoOsebje.setObisk(null);

		return dodeljenoOsebje;
	}

	public List<Injekcije> getInjekcijes() {
		return this.injekcijes;
	}

	public void setInjekcijes(List<Injekcije> injekcijes) {
		this.injekcijes = injekcijes;
	}

	public Injekcije addInjekcije(Injekcije injekcije) {
		getInjekcijes().add(injekcije);
		injekcije.setObisk(this);

		return injekcije;
	}

	public Injekcije removeInjekcije(Injekcije injekcije) {
		getInjekcijes().remove(injekcije);
		injekcije.setObisk(null);

		return injekcije;
	}

	public DelovniNalog getDelovniNalog() {
		return this.delovniNalog;
	}

	public void setDelovniNalog(DelovniNalog delovniNalog) {
		this.delovniNalog = delovniNalog;
	}

	public StatusObiska getStatusObiskaBean() {
		return this.statusObiskaBean;
	}

	public void setStatusObiskaBean(StatusObiska statusObiskaBean) {
		this.statusObiskaBean = statusObiskaBean;
	}

	public List<OdvzemKrvi> getOdvzemKrvis() {
		return this.odvzemKrvis;
	}

	public void setOdvzemKrvis(List<OdvzemKrvi> odvzemKrvis) {
		this.odvzemKrvis = odvzemKrvis;
	}

	public OdvzemKrvi addOdvzemKrvi(OdvzemKrvi odvzemKrvi) {
		getOdvzemKrvis().add(odvzemKrvi);
		odvzemKrvi.setObisk(this);

		return odvzemKrvi;
	}

	public OdvzemKrvi removeOdvzemKrvi(OdvzemKrvi odvzemKrvi) {
		getOdvzemKrvis().remove(odvzemKrvi);
		odvzemKrvi.setObisk(null);

		return odvzemKrvi;
	}

	public List<OstaliPodatki> getOstaliPodatkis() {
		return this.ostaliPodatkis;
	}

	public void setOstaliPodatkis(List<OstaliPodatki> ostaliPodatkis) {
		this.ostaliPodatkis = ostaliPodatkis;
	}

	public OstaliPodatki addOstaliPodatki(OstaliPodatki ostaliPodatki) {
		getOstaliPodatkis().add(ostaliPodatki);
		ostaliPodatki.setObisk(this);

		return ostaliPodatki;
	}

	public OstaliPodatki removeOstaliPodatki(OstaliPodatki ostaliPodatki) {
		getOstaliPodatkis().remove(ostaliPodatki);
		ostaliPodatki.setObisk(null);

		return ostaliPodatki;
	}

}
