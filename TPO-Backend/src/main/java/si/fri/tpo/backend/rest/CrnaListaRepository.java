package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.CrnaLista;

@RepositoryRestResource(collectionResourceRel = "CrnaLista", path="crnaLista")
public interface CrnaListaRepository extends JpaRepository<CrnaLista, Integer> {

}
