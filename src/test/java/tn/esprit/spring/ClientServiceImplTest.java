package tn.esprit.spring;

import static org.junit.Assert.*;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.DAO.entites.CategorieClient;
import tn.esprit.spring.DAO.entites.Client;
import tn.esprit.spring.DAO.entites.Facture;
import tn.esprit.spring.DAO.entites.Profession;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.services.IClientService;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {

	@Autowired
	IClientService clientService;
	
	@Test
	public void testAdClient() {
		List<Client> Clients = (List<Client>) clientService.retrieveAllClients();
		int expected = Clients.size();
Client client = new Client();
//Facture factures = new Facture();
Set<Facture>factures= new HashSet<>();
client.setCategorieClient(CategorieClient.ORDINAIRE);
client.setDateNaissance(new Date());
client.setEmail("eskander.jguirim@esprit.tn");
client.setNom("jg");
//client.setFactures(factures);
client.setPassword("123");
client.setPrenom("eskander");
client.setProfession(Profession.AUTRE);

Client saved = clientService.addClient(client);

int expected2=clientService.countnbrclient();

assertEquals(expected2, clientService.retrieveAllClients());
assertNotNull(saved.getIdClient());
clientService.deleteClient(String.valueOf(client.getIdClient()));
	}
	
	@Test
	public void testDelete() {
		
		List<Client> Clients = (List<Client>) clientService.retrieveAllClients();
		int expected = Clients.size();
		
		System.out.println("expected1 = "+expected);
		
		clientService.deleteClient(String.valueOf(24));
		
		  int expected2=clientService.countnbrclient();

		System.out.println("expected2 = "+expected2);
		
		assertEquals(expected2, clientService.retrieveAllClients());

	}
	

}
