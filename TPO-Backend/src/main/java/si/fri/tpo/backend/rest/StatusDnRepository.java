package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.StatusDn;

@RepositoryRestResource(collectionResourceRel = "StatusDn", path="statusDn")
public interface StatusDnRepository extends JpaRepository<StatusDn, Integer> {

}
