package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.OdvzemKrvi;

@RepositoryRestResource(collectionResourceRel = "OdvzemKrvi", path="odvzemKrvi")
public interface OdvzemKrviRepository extends JpaRepository<OdvzemKrvi, Integer> {

}
