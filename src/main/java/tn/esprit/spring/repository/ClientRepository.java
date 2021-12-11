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

	@Transactional
	@Modifying
	@Query("update Client c set c.categorieClient = :categorie where c.idClient= :idClient")
	int updateCategorieClient(@Param("idClient") Long idClient,@Param("categorie") CategorieClient categorieClient);
	
	@Modifying
	@Query("DELETE FROM Client c WHERE c.idClient= :idclient")
	int deleteClientByidClient(@Param("idclient") Long idClient);
	
	@Query("SELECT c FROM Client c WHERE c.categorieClient= :categorie")
	List<Client> retrieveClientByCategorie(@Param("categorie") CategorieClient CategorieClient);
	
	//@Query("SELECT sum(c.idClient) FROM Client c order by c.categorieClient")
	//int statCatClient();
	
	@Query("SELECT c FROM Client c WHERE c.profession= :profession")
	List<Client> retrieveClientByProfession(@Param("profession") Profession Profession);
	
	@Query("SELECT COUNT(c.idClient) FROM Client c WHERE c.categorieClient= :categorie")
	int statClientByCat(@Param("categorie") CategorieClient CategorieClient);
	
	
	@Query("SELECT c FROM Client c WHERE c.profession= :profession and  c.categorieClient= :categorie")
	List<Client> retrieveClientByProfessionANDcategorie(@Param("profession") Profession Profession,@Param("categorie") CategorieClient CategorieClient);
	
	@Query("SELECT COUNT(c) FROM Client c ")
	int coutnbreClient();

	
	@Query("SELECT c.factures FROM Client c WHERE c.categorieClient= :categorie")
	List<Facture> FactureClientByCategorie(@Param("categorie") CategorieClient CategorieClient);
	
	@Query("SELECT c.factures FROM Client c WHERE c.idClient= :idClient")
	List<Facture> FactureParClient(@Param("idClient") Long idClient);
	
	@Query("SELECT c FROM Client c WHERE c.idClient= :idClient")
	List<Client> ClientById(@Param("idClient") Long idClient);
	
	@Modifying
	@Query(value = "INSERT INTO Client (nom, prenom,dateNaissance,email,password,profession,categorieClient) VALUES (:nom, :prenom, :dateN, :email, :password, :profession, :categorieClient)",
	nativeQuery = true)
	void insertClient(@Param("nom") String nom, @Param("prenom") String prenom,
	@Param("dateN") Date dateNaissance, @Param("email") String email,
	@Param("password") String password, @Param("profession") Profession
	profession, @Param("categorieClient") CategorieClient categorieClient);
	
	
	@Query("SELECT df.Produit FROM DetailFacture df,Client c ,Facture f WHERE (c.idClient= :idclient) and (f.client.idClient= :idclient) and (f.idFacture=:idfacture) and(df.factures.idFacture=:idfacture)")
	List<Produit> ListProduitByFacture(@Param("idclient") Long idClient,@Param("idfacture") Long idfacture);
	
	
}
