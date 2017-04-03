package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.UporabniškiRačun;

@RepositoryRestResource(collectionResourceRel = "UporabniškiRačun", path="uporabniškiRačun")
public interface UporabniškiRačunRepository extends JpaRepository<UporabniškiRačun, Integer> {
}
