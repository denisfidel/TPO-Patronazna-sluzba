package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.Injekcije;

@RepositoryRestResource(collectionResourceRel = "Injekcije", path="injekcije")
public interface InjekcijeRepository extends JpaRepository<Injekcije, Integer> {

}
