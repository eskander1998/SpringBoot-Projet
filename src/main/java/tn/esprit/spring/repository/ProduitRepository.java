package tn.esprit.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entites.*;

@Repository()
public interface ProduitRepository extends CrudRepository<Produit, Long> {

	
	//void findByAgeGreaterThan(int age);
	void findByPrixUnitaireGreaterThan(long produit);
}
