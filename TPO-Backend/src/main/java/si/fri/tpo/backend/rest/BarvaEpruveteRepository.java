package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.BarvaEpruvete;

@RepositoryRestResource(collectionResourceRel = "BarvaEpruvete", path="barvaEpruvete")
public interface BarvaEpruveteRepository extends JpaRepository<BarvaEpruvete, Integer> {

}
