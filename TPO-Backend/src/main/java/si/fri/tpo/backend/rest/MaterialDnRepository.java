package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.MaterialDn;

@RepositoryRestResource(collectionResourceRel = "MaterialDn", path="materialDn")
public interface MaterialDnRepository extends JpaRepository<MaterialDn, Integer> {

}
