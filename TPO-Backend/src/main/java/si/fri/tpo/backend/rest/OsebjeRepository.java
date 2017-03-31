package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.Osebje;

@RepositoryRestResource(collectionResourceRel = "Osebje", path="osebje")
public interface OsebjeRepository extends JpaRepository<Osebje, Integer> {

}
