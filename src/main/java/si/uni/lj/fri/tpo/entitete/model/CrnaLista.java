package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the crna_lista database table.
 * 
 */
@Entity
@Table(name="crna_lista")
@NamedQuery(name="CrnaLista.findAll", query="SELECT c FROM CrnaLista c")
public class CrnaLista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_zaklepanja", nullable=false)
	private Date datumZaklepanja;

	@Column(nullable=false, length=2147483647)
	private String ip;

	@Column(nullable=false)
	private Integer poiskusi;

	//bi-directional many-to-one association to UporabniškiRačun
	@ManyToOne
	@JoinColumn(name="id_ur", nullable=false)
	private UporabniškiRačun uporabniškiRačun;

	public CrnaLista() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatumZaklepanja() {
		return this.datumZaklepanja;
	}

	public void setDatumZaklepanja(Date datumZaklepanja) {
		this.datumZaklepanja = datumZaklepanja;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPoiskusi() {
		return this.poiskusi;
	}

	public void setPoiskusi(Integer poiskusi) {
		this.poiskusi = poiskusi;
	}

	public UporabniškiRačun getUporabniškiRačun() {
		return this.uporabniškiRačun;
	}

	public void setUporabniškiRačun(UporabniškiRačun uporabniškiRačun) {
		this.uporabniškiRačun = uporabniškiRačun;
	}

}