package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.Okoli;

@RepositoryRestResource(collectionResourceRel = "Okoli", path="okoli")
public interface OkoliRepository extends JpaRepository<Okoli, Integer> {

}
