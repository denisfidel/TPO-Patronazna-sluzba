package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.Obisk;

@RepositoryRestResource(collectionResourceRel = "Obisk", path="obisk")
public interface ObiskRepository extends JpaRepository<Obisk, Integer> {

}
