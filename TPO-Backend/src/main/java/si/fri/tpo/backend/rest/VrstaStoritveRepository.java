package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.VrstaStoritve;

@RepositoryRestResource(collectionResourceRel = "VrstaStoritve", path="vrstaStoritve")
public interface VrstaStoritveRepository extends JpaRepository<VrstaStoritve, Integer> {

}
