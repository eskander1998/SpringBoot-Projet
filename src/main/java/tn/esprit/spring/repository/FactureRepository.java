package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.entites.Facture;

public interface FactureRepository extends CrudRepository<Facture, Long> {

}
