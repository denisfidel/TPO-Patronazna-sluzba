package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.VrstaPodatka;

@RepositoryRestResource(collectionResourceRel = "VrstaPodatka", path="vrstaPodatka")
public interface VrstaPodatkaRepository extends JpaRepository<VrstaPodatka, Integer> {

}
