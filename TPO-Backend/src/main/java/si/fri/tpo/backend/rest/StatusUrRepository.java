package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.StatusUr;

@RepositoryRestResource(collectionResourceRel = "StatusUr", path="statusUr")
public interface StatusUrRepository extends JpaRepository<StatusUr, Integer> {

}
