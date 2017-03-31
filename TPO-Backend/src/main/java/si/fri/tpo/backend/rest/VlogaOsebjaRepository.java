package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.VlogaOsebja;

@RepositoryRestResource(collectionResourceRel = "VlogaOsebja", path="vlogaOsebja")
public interface VlogaOsebjaRepository extends JpaRepository<VlogaOsebja, Integer> {

}
