package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entites.*;

public interface IProduitService {

	 List<Produit> retrieveAllProduits();
	 Produit addProduit(Produit u, Long idRayon,Long idStock );
	 void deleteProduit(String id);
	 Produit updateProduit(Produit u);
	 Produit retrieveProduit(long id);
	 
	 
	 
	 
}
