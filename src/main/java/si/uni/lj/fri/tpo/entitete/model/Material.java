package si.uni.lj.fri.tpo.entitete.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the material database table.
 * 
 */
@Entity
@Table(name="material")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	private Integer naziv;

	@Column(length=20)
	private String sifra;

	//bi-directional many-to-one association to MaterialDn
	@OneToMany(mappedBy="material")
	private List<MaterialDn> materialDns;

	public Material() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNaziv() {
		return this.naziv;
	}

	public void setNaziv(Integer naziv) {
		this.naziv = naziv;
	}

	public String getSifra() {
		return this.sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public List<MaterialDn> getMaterialDns() {
		return this.materialDns;
	}

	public void setMaterialDns(List<MaterialDn> materialDns) {
		this.materialDns = materialDns;
	}

	public MaterialDn addMaterialDn(MaterialDn materialDn) {
		getMaterialDns().add(materialDn);
		materialDn.setMaterial(this);

		return materialDn;
	}

	public MaterialDn removeMaterialDn(MaterialDn materialDn) {
		getMaterialDns().remove(materialDn);
		materialDn.setMaterial(null);

		return materialDn;
	}

}