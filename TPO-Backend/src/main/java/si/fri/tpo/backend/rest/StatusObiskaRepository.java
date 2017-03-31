package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.StatusObiska;

@RepositoryRestResource(collectionResourceRel = "StatusObiska", path="statusObiska")
public interface StatusObiskaRepository extends JpaRepository<StatusObiska, Integer> {

}
