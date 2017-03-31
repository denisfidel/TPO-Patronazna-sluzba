package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.VrstaObiska;

@RepositoryRestResource(collectionResourceRel = "VrstaObiska", path="vrstaObiska")
public interface VrstaObiskaRepository extends JpaRepository<VrstaObiska, Integer> {

}
