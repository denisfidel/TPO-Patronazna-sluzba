package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.Material;

@RepositoryRestResource(collectionResourceRel = "Material", path="material")
public interface MaterialRepository extends JpaRepository<Material, Integer> {

}
