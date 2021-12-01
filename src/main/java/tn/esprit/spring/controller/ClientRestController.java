package tn.esprit.spring.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.EmailServiceImpl;
import tn.esprit.spring.services.IClientService;
import tn.esprit.spring.DAO.entites.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ClientRestController {

	
	@Autowired
	IClientService clientService;

	@Autowired
	EmailServiceImpl emailService;
	
	//http://localhost:8081/SpringMVC/client/retrieve-all-clients
	@GetMapping("/retrieve-all-clients")
	public List<Client> getClients() {
		
	List<Client> Clients = clientService.retrieveAllClients();
	
	return Clients; 
	}
	
	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@GetMapping("/retrieve-client/{client-id}")
	@ResponseBody
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
	return clientService.retrieveClient(clientId);
	}

	@GetMapping("/nbclient")
	@ResponseBody
	public int nbclient() {
	return clientService.countnbrclient();
	}
	
	@GetMapping("/nbr-fc-client/{client-id}")
	@ResponseBody
	public int CountFactByClient(@PathVariable("client-id") Long clientId) {
	 List<Facture> list =clientService.FactureParClient(clientId);
	 return list.size();
	}
	
	@GetMapping("/facture/{client-id}")
	@ResponseBody
	public  List<Facture> FactByClient(@PathVariable("client-id") Long clientId) {
	 List<Facture> list =clientService.FactureParClient(clientId);
	 
	 return list;
	}
	
	
	//methode1
	@GetMapping("/chiffre-affaire-by-cat/{categorie-client}/{start}/{end}")
	@ResponseBody
	public  float getChiffreAffaireParCategorieClient(@PathVariable("categorie-client")  CategorieClient categorieClient,@PathVariable("start")  @DateTimeFormat(pattern="yyyy-MM-dd") Date StartDate,@PathVariable("end")@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
		Float CA =clientService.getChiffreAffaireParCategorieClient(categorieClient,StartDate,endDate);
	 return CA;
	}
	
	//methode2
	@GetMapping("/chiffre-affaire-by-cat2/{categorie-client}/{start}/{end}")
	@ResponseBody
	public  float getChiffreAffaireParCategorieClient2(@PathVariable("categorie-client")  CategorieClient categorieClient,@PathVariable("start")  @DateTimeFormat(pattern="yyyy-MM-dd") Date StartDate,@PathVariable("end")@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
		Float CA =clientService.getChiffreAffaireParCategorieClient(categorieClient,StartDate,endDate);
	 return CA;
	}
	
	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-client")
	@ResponseBody
	public Client addClient(@RequestBody Client c)
	{
	Client client = clientService.addClient(c);
	return client;
	}
	
	// http://localhost:8089/SpringMVC/client/add-client
		@PostMapping("/add-client-repo")
		@ResponseBody
		public Client addClientRepo(@RequestBody Client c)
		{
		Client client = clientService.addClientRepo(c);
		return client;
		}
	
	
	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") String clientId) {
	clientService.deleteClient(clientId);
	}

	
	@GetMapping("/retrieve-client-byCategorieClient/{categorie-client}")
	@ResponseBody
	public List<Client> retrieveClientbyCategorie(@PathVariable("categorie-client") CategorieClient CategorieClient) {
		return	clientService.retrieveClientbyCategorie(CategorieClient);
	}
	
	@GetMapping("/retrieve-client-byProfession/{profession}")
	@ResponseBody
	public List<Client> retrieveClientbyProfession(@PathVariable("profession") Profession Profession) {
		return	clientService.retrieveClientbyProfession(Profession);
	}
	
	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client) {
	return clientService.updateClient(client);
	}
	
	@PutMapping("/modify-client-by-id/{client-id}")
	@ResponseBody
	public Client modifyClientById(@RequestBody Client client,@PathVariable("client-id") Long clientId) {
	return clientService.updateClientById(client, clientId);
	}
	
	
	
}
