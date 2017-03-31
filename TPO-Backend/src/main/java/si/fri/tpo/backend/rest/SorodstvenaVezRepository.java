package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.SorodstvenaVez;

@RepositoryRestResource(collectionResourceRel = "SorodstvenaVez", path="posta")
public interface SorodstvenaVezRepository extends JpaRepository<SorodstvenaVez, Integer> {

}
