package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import tn.esprit.spring.DAO.entites.CategorieClient;
import tn.esprit.spring.DAO.entites.Client;
import tn.esprit.spring.DAO.entites.Facture;
import tn.esprit.spring.DAO.entites.Produit;
import tn.esprit.spring.DAO.entites.Profession;

@Repository()
public interface ClientRepository extends CrudRepository<Client, Long> {
/*
	@Query("select c from Client c where c.Profession=?1")
	List<Client> retrieveAllClientsByProfession(Profession profession);
	*/ 
	/*@Query("select c from Client c where c.dateNaissance BETWEEN :debut and :fin")
	List<Client> retrieveAllClientsByBirthday(@Param("debut") Date debut, @Param("fin") Date fin);*/
	//@GetMapping
	//@Query("select c from Client c")
//	List<Client> retrieveAllClientsByBirthday(@Param("debut") Date debut, @Param("fin") Date fin);
	
	
/*	@Modifying
	@Query("update Client c set c.categorieClient = :categorie where u.profession =:profession")
	Long updateClientCategorieByProfession(@Param("categorie") CategorieClient
	categorieClient, @Param("profession") Profession profession);
	
	@Modifying
	@Query("DELETE FROM Client c WHERE c.categorieClient= :categorie AND c.profession = :profession")
	Long deleteClientByCategorieClientAndProfession(@Param("categorie")
	CategorieClient categorieClient, @Param("profession") Profession profession);
	*/
	
	@Transactional
	@Modifying
	@Query("update Client c set c.categorieClient = :categorie where c.idClient= :idClient")
	int updateCategorieClient(@Param("idClient") Long idClient,@Param("categorie") CategorieClient categorieClient);
	
	@Modifying
	@Query("DELETE FROM Client c WHERE c.idClient= :idclient")
	int deleteClientByidClient(@Param("idclient") Long idClient);
	
	@Query("SELECT c FROM Client c WHERE c.categorieClient= :categorie")
	List<Client> retrieveClientByCategorie(@Param("categorie") CategorieClient CategorieClient);
	
	@Query("SELECT c FROM Client c WHERE c.profession= :profession")
	List<Client> retrieveClientByProfession(@Param("profession") Profession Profession);
	
	
	@Query("SELECT COUNT(c) FROM Client c ")
	int coutnbreClient();
	
/*	@Query("SELECT COUNT(f.idFacture) FROM Client c , Facture f WHERE c.idClient= :idClient and f.client= :client")
	int countFactureParClient(@Param("idClient") Long idClient,@Param("client") Client c);
	*/
	
	@Query("SELECT c.factures FROM Client c WHERE c.categorieClient= :categorie")
	List<Facture> FactureClientByCategorie(@Param("categorie") CategorieClient CategorieClient);
	
	@Query("SELECT c.factures FROM Client c WHERE c.idClient= :idClient")
	List<Facture> FactureParClient(@Param("idClient") Long idClient);
	

	@Modifying
	@Query(value = "INSERT INTO Client (nom, prenom,dateNaissance,email,password,profession,categorieClient) VALUES (:nom, :prenom, :dateN, :email, :password, :profession, :categorieClient)",
	nativeQuery = true)
	void insertClient(@Param("nom") String nom, @Param("prenom") String prenom,
	@Param("dateN") Date dateNaissance, @Param("email") String email,
	@Param("password") String password, @Param("profession") Profession
	profession, @Param("categorieClient") CategorieClient categorieClient);
	
	
}
