package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.NamenObiska;

@RepositoryRestResource(collectionResourceRel = "NamenObiska", path="namenObiska")
public interface NamenObiskaRepository extends JpaRepository<NamenObiska, Integer> {

}
