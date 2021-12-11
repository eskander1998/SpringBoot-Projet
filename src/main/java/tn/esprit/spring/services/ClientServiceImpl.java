package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entites.CategorieClient;
import tn.esprit.spring.DAO.entites.Client;
import tn.esprit.spring.DAO.entites.Facture;
import tn.esprit.spring.DAO.entites.Produit;
import tn.esprit.spring.DAO.entites.Profession;
import tn.esprit.spring.DAO.entites.Stock;
import tn.esprit.spring.repository.*;


@Service()
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	EmailServiceImpl emailService;
	@Autowired
	FactureRepository FactureRepo;
	
	

	//methode1
	 public  float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,Date StartDate,Date endDate)
	 {
		 List<Client> Clients = (List<Client>) clientRepository.retrieveClientByCategorie(categorieClient);
		 List<Facture> Factures = (List<Facture>) FactureRepo.findAll();

		 float totale=0;
		 
			for(Client client: Clients){
				for(Facture facture: Factures){
					
					if(client.getIdClient()==facture.getClient().getIdClient())
					{
						totale = totale+ facture.getMontantFacture();
					}
					
				
				}
			}
		 return totale;
	 }
	 
	//methode2
	public  float getChiffreAffaireParCategorieClient2(CategorieClient categorieClient,Date StartDate,Date endDate)
	 {
		 List<Facture> Factures = (List<Facture>) clientRepository.FactureClientByCategorie(categorieClient);

		 float totale=0; 
		 
		for(Facture facture: Factures){
					
		totale = totale+ facture.getMontantFacture();
	
			}
		 return totale;
	 }
	 
	public int countnbrclient(){
		
		return clientRepository.coutnbreClient();
	}

	//Methode qui met a jour la categorie des clients chaque 30 min en fonction du nombre d'achat qu'ils ont effectué
	//En fonction du nombre d'achat, leur catégorie change et il reçoive un code promo par mail pour leur prochains achats
	//@Scheduled(cron = "*/20 * * * * *")
	
	@Scheduled(cron = "0 0/30 * * * *")
	@Override
	public int updateCategorieClient()
	{	
		List<Client> Clients = (List<Client>) clientRepository.findAll();
		for(Client client: Clients){
		//	System.out.println("clients +++: " + client );
			
		System.out.println("verif de la categorie");
			if(client.getFactures().size()<=3 && client.getCategorieClient()!=CategorieClient.ORDINAIRE )
			{
			
				System.out.println("le client "+client.getNom()+" "+client.getPrenom()+" a "+client.getFactures().size()+" factures");
				clientRepository.updateCategorieClient(client.getIdClient(),CategorieClient.ORDINAIRE);
			
			}
			 if(client.getFactures().size()>=4 && client.getFactures().size()<=5  && client.getCategorieClient()!=CategorieClient.FIDELE)
			{
				String text="Bonjour "+client.getPrenom()+" "+client.getNom()+".\n\nVous êtes désormais un client "
						+ "fidéle chez Best Shop. Pour vous remercier de voter confiance, vous bénéficierez d'une remise de 5% pour "
						+ "tout vos prochains achat.\n\n Merci et à bientôt";
				
				System.out.println("le client "+client.getNom()+" "+client.getPrenom()+" a "+client.getFactures().size()+" factures");

				
				clientRepository.updateCategorieClient(client.getIdClient(),CategorieClient.FIDELE);
				 
					
					try {
						emailService.sendSimpleMessage(client.getEmail(), "Magasin Best Shop", text);

					} catch (Exception e) {
						// TODO: handle exception
					}

			}
			 if(client.getFactures().size()>=6 && client.getCategorieClient()!=CategorieClient.PREMIUM)
			{
				String text="Bonjour "+client.getPrenom()+" "+client.getNom()+".\n\nVous êtes désormais un client "
						+ "fidéle chez Best Shop. Pour vous remercier de voter confiance, vous bénéficierez d'une remise de 10% pour "
						+ "tout vos prochains achat.\n\n Merci et à bientôt";
				
				System.out.println("le client "+client.getNom()+" "+client.getPrenom()+" a "+client.getFactures().size()+" factures");

				clientRepository.updateCategorieClient(client.getIdClient(),CategorieClient.PREMIUM);

				
				try {
					emailService.sendSimpleMessage(client.getEmail(), "Magasin Best Shop", text);

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}		
		return 1;
	}
	
	@Override
	public List<Client> retrieveAllClients() {

		List<Client> Clients = (List<Client>) clientRepository.findAll();
		for(Client client: Clients){
			System.out.println("clients +++: " + client );
			
		}		
		return Clients;
	}

	
	@Override
	public  List<Facture> FactureParClient(long id){
		return clientRepository.FactureParClient(id);
		
	}
/*	public List<Client> retrieveAllClientsByBirthday(Date debut,Date fin)
	{
		return clientRepository.retrieveAllClientsByBirthday(debut, fin);
	}*/

	@Override
	public Client addClient(Client u) {
		
		clientRepository.save(u);
		return u;
	}

	
	public Client addClientRepo(Client u) {
	
 clientRepository.insertClient(u.getNom(), u.getPrenom(), u.getDateNaissance(),u.getEmail(), u.getPassword(), u.getProfession(), u.getCategorieClient());
	return u;
	}
	

	@Override
	public void deleteClient(String id) {

	clientRepository.deleteById(Long.parseLong(id));
			    
	}
	
	
	
	
	
	@Override
	public
	 List<Client> retrieveClientbyProfession(Profession Profession){
		return clientRepository.retrieveClientByProfession(Profession);

	 }
	
	@Override
	public List<Client> retrieveClientbyCategorie(CategorieClient categorieClient) {
	return clientRepository.retrieveClientByCategorie(categorieClient);
		
			    
	}
	
	@Override
	public Client updateClient(Client u) {
		long id= u.getIdClient();
		Optional<Client> Clients = clientRepository.findById(id);

		if(Clients!=null)
clientRepository.save(u);
		
		return u;
	}
	

	 
/*
	public Long updateClientByProfession(CategorieClient c,Profession f) {
	 return clientRepository.updateClientCategorieByProfession(c,f);
	}
	
	public Long deleteClientByCategorieClientAndProfession(CategorieClient c,Profession f) {
		 return clientRepository.deleteClientByCategorieClientAndProfession(c,f);
		}
		*/
	
	@Override
	public Client retrieveClient(long id) {

		Client Client = null;

		try {
			Client = clientRepository.findById(id).get();

		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
		
		return Client;
	}
	
	
	
	@Override
	public Client updateClientById(Client u, Long id) {
		long idd= u.getIdClient();
		if(id==idd)
		{
		Optional<Client> Clients = clientRepository.findById(id);
		
		if(Clients!=null)
clientRepository.save(u);
		}
		return u;		
	}

	  /*
	@Scheduled(fixedRate = 60000)
	@Override
	public void statut_stock(){
		 List<Stock> stocks = (List<Stock>) StockRepository.findAll();
	        for(Stock stock :stocks)
	        {
	        	 System.out.println("stock ++ " +stock.getQteStock());
	        	 if(stock.getQteStock()==0){
	        		 System.out.println("stock perime");}else
	        			 System.out.println("stock non perime");
	        			 
	    }
	        }
	*//*
	@Scheduled(cron = "0 0 1 1 *")
	@Override
	public	float revenueMagasin(){
		float revenue =FactureRepository.revenueMagasin();
		return revenue;
	}*/

	public List<Client> retrieveClientbyCategorieAndProfession(Profession Profession , CategorieClient CategorieClient)
	 {
		 
		return clientRepository.retrieveClientByProfessionANDcategorie(Profession, CategorieClient)	 ;
	
	 }

	 public float getMoneySpentByOneClient(Long idClient){
		 
		 List<Facture> factures = clientRepository.FactureParClient(idClient);
		 float totale=0;
		 
			for(Facture facture: factures){
						
			totale = totale+ facture.getMontantFacture();
		
				}
			 return totale;
			 
	 }

	 public int statClientByCat(CategorieClient cat){
		 return clientRepository.statClientByCat(cat);
	 }

	 
	 public List<Produit> ListProduitByFacture( Long idClient,Long idFacture){
			
		 return clientRepository.ListProduitByFacture(idClient,idFacture);
	 }

	
}
