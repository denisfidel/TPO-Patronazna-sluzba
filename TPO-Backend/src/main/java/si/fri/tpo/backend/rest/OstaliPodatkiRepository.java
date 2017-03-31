package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.OstaliPodatki;

@RepositoryRestResource(collectionResourceRel = "OstaliPodatki", path="ostaliPodatki")
public interface OstaliPodatkiRepository extends JpaRepository<OstaliPodatki, Integer> {

}
