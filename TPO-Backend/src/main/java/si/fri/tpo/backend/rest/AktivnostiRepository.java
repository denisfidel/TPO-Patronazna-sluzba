package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.Aktivnosti;

@RepositoryRestResource(collectionResourceRel = "Aktivnosti", path="aktivnosti")
public interface AktivnostiRepository extends JpaRepository<Aktivnosti, Integer> {

}
