package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entites.*;


public interface IClientService {
	 List<Client> retrieveAllClients();
	 Client addClient(Client u);
	 Client addClientRepo(Client u);
	 void deleteClient(String id);
	 Client updateClient(Client u);
	 Client updateClientById(Client u,Long id);
	 
	 float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,Date StartDate,Date endDate);
	 
	 List<Client> retrieveClientbyProfession(Profession Profession);
	 List<Client> retrieveClientbyCategorie(CategorieClient CategorieClient);
	 // Long updateClientByProfession(CategorieClient c,Profession f);
	 Client retrieveClient(long id);
	 
	// void fixedRateMethod();
	 //void cron1();
		//void statut_stock();
		
		int countnbrclient();
		 float getChiffreAffaireParCategorieClient2(CategorieClient categorieClient,Date StartDate,Date endDate);
	 int updateCategorieClient();
	 List<Facture> FactureParClient(long id);
	// List<Client> retrieveAllClientsFromDB(Profession c);
//	 Long deleteClientByCategorieClientAndProfession (CategorieClient c,Profession f);
	// List<Client> retrieveAllClientsByBirthday(Date debut,Date fin);

}
