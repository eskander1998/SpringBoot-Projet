package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entites.*;

@Repository

public interface DetailFactureRepository extends CrudRepository<DetailFacture, Long> {

}
