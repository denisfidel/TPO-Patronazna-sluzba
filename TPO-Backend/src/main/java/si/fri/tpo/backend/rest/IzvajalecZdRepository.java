package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.IzvajalecZd;

@RepositoryRestResource(collectionResourceRel = "IzvajalecZd", path="izvajalecZd")
public interface IzvajalecZdRepository extends JpaRepository<IzvajalecZd, Integer> {

}
