package si.fri.tpo.backend.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import si.fri.tpo.backend.jpa.Zdravila;

@RepositoryRestResource(collectionResourceRel = "Zdravila", path="zdravila")
public interface ZdravilaRepository extends JpaRepository<Zdravila, Integer> {

}
