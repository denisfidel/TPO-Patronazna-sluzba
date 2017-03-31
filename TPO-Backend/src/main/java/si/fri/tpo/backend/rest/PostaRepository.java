package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.Posta;

@RepositoryRestResource(collectionResourceRel = "Posta", path="posta")
public interface PostaRepository extends JpaRepository<Posta, Integer> {

}
