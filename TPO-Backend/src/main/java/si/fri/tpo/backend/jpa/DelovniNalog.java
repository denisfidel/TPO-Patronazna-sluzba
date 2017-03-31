package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the delovni_nalog database table.
 *
 */
@Entity
@Table(name="delovni_nalog")
@NamedQuery(name="DelovniNalog.findAll", query="SELECT d FROM DelovniNalog d")
public class DelovniNalog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="cas_med_dvema", nullable=false)
	private Integer casMedDvema;

	@Temporal(TemporalType.DATE)
	@Column(name="casovno_obdobje", nullable=false)
	private Date casovnoObdobje;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_prvega_obiska", nullable=false)
	private Date datumPrvegaObiska;

	@Column(name="st_obiskov", nullable=false)
	private Integer stObiskov;

	//bi-directional many-to-one association to Osebje
	@ManyToOne
	@JoinColumn(name="id_osebje", nullable=false)
	private Osebje osebje;

	//bi-directional many-to-one association to StatusDn
	@ManyToOne
	@JoinColumn(name="status_dn", nullable=false)
	private StatusDn statusDnBean;

	//bi-directional many-to-one association to VrstaObiska
	@ManyToOne
	@JoinColumn(name="id_vrsta", nullable=false)
	private VrstaObiska vrstaObiska;

	//bi-directional many-to-one association to VrstaStoritve
	@ManyToOne
	@JoinColumn(name="vrsta_storitve")
	private VrstaStoritve vrstaStoritveBean;

	//bi-directional many-to-one association to MaterialDn
	@OneToMany(mappedBy="delovniNalog")
	private List<MaterialDn> materialDns;

	//bi-directional many-to-one association to Obisk
	@OneToMany(mappedBy="delovniNalog")
	private List<Obisk> obisks;

	//bi-directional many-to-many association to Pacient
	@ManyToMany(mappedBy="delovniNalogs")
	private List<Pacient> pacients;

	public DelovniNalog() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCasMedDvema() {
		return this.casMedDvema;
	}

	public void setCasMedDvema(Integer casMedDvema) {
		this.casMedDvema = casMedDvema;
	}

	public Date getCasovnoObdobje() {
		return this.casovnoObdobje;
	}

	public void setCasovnoObdobje(Date casovnoObdobje) {
		this.casovnoObdobje = casovnoObdobje;
	}

	public Date getDatumPrvegaObiska() {
		return this.datumPrvegaObiska;
	}

	public void setDatumPrvegaObiska(Date datumPrvegaObiska) {
		this.datumPrvegaObiska = datumPrvegaObiska;
	}

	public Integer getStObiskov() {
		return this.stObiskov;
	}

	public void setStObiskov(Integer stObiskov) {
		this.stObiskov = stObiskov;
	}

	public Osebje getOsebje() {
		return this.osebje;
	}

	public void setOsebje(Osebje osebje) {
		this.osebje = osebje;
	}

	public StatusDn getStatusDnBean() {
		return this.statusDnBean;
	}

	public void setStatusDnBean(StatusDn statusDnBean) {
		this.statusDnBean = statusDnBean;
	}

	public VrstaObiska getVrstaObiska() {
		return this.vrstaObiska;
	}

	public void setVrstaObiska(VrstaObiska vrstaObiska) {
		this.vrstaObiska = vrstaObiska;
	}

	public VrstaStoritve getVrstaStoritveBean() {
		return this.vrstaStoritveBean;
	}

	public void setVrstaStoritveBean(VrstaStoritve vrstaStoritveBean) {
		this.vrstaStoritveBean = vrstaStoritveBean;
	}

	public List<MaterialDn> getMaterialDns() {
		return this.materialDns;
	}

	public void setMaterialDns(List<MaterialDn> materialDns) {
		this.materialDns = materialDns;
	}

	public MaterialDn addMaterialDn(MaterialDn materialDn) {
		getMaterialDns().add(materialDn);
		materialDn.setDelovniNalog(this);

		return materialDn;
	}

	public MaterialDn removeMaterialDn(MaterialDn materialDn) {
		getMaterialDns().remove(materialDn);
		materialDn.setDelovniNalog(null);

		return materialDn;
	}

	public List<Obisk> getObisks() {
		return this.obisks;
	}

	public void setObisks(List<Obisk> obisks) {
		this.obisks = obisks;
	}

	public Obisk addObisk(Obisk obisk) {
		getObisks().add(obisk);
		obisk.setDelovniNalog(this);

		return obisk;
	}

	public Obisk removeObisk(Obisk obisk) {
		getObisks().remove(obisk);
		obisk.setDelovniNalog(null);

		return obisk;
	}

	public List<Pacient> getPacients() {
		return this.pacients;
	}

	public void setPacients(List<Pacient> pacients) {
		this.pacients = pacients;
	}

}
