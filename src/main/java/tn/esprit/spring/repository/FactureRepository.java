package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entites.Client;
import tn.esprit.spring.DAO.entites.Facture;
import tn.esprit.spring.DAO.entites.Profession;

public interface FactureRepository extends CrudRepository<Facture, Long> {

	
	
}
