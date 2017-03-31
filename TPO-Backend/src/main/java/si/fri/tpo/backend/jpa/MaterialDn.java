package si.fri.tpo.backend.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the material_dn database table.
 *
 */
@Entity
@Table(name="material_dn")
@NamedQuery(name="MaterialDn.findAll", query="SELECT m FROM MaterialDn m")
public class MaterialDn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Column(nullable=false)
	private Integer kolicina;

	//bi-directional many-to-one association to DelovniNalog
	@ManyToOne
	@JoinColumn(name="id_dn", nullable=false)
	private DelovniNalog delovniNalog;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="id_material")
	private Material material;

	public MaterialDn() {
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public DelovniNalog getDelovniNalog() {
		return this.delovniNalog;
	}

	public void setDelovniNalog(DelovniNalog delovniNalog) {
		this.delovniNalog = delovniNalog;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}
