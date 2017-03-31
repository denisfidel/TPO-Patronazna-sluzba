package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.KontaktnaOseba;

@RepositoryRestResource(collectionResourceRel = "KontaktnaOseba", path="kontaktnaOseba")
public interface KontaktnaOsebaRepository extends JpaRepository<KontaktnaOseba, Integer> {

}
