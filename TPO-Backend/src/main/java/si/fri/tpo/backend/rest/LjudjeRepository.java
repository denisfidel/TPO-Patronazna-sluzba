package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.Ljudje;

@RepositoryRestResource(collectionResourceRel = "Ljudje", path="ljudje")
public interface LjudjeRepository extends JpaRepository<Ljudje, Integer> {

}
