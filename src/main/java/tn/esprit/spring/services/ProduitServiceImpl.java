package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entites.DetailProduit;
import tn.esprit.spring.DAO.entites.Produit;
import tn.esprit.spring.repository.*;

@Service()
public class ProduitServiceImpl implements IProduitService{

	
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	rayonRepository rayonRepository;
	@Autowired
	DetailProduitRepository DetailProduitRepo;
	@Autowired
	StockRepository StockRepository;
	//private static final Logger L = LogManager.getLogger(ProduitServiceImpl.class);
	
	@Override
	public List<Produit> retrieveAllProduits() {

		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		
		for(Produit produit: produits){
			System.out.println("produits +++: " + produit );
		} 
		return produits;
	}


	private DetailProduit saveDetailProduit(Produit p){
		
		if(p.getDetailProduit().getDateCreation()==null){
			p.getDetailProduit().setDateCreation(new Date());
			p.getDetailProduit().setDateDerniereModification(new Date());
		}
		else 
		{
			p.getDetailProduit().setDateDerniereModification(new Date());
		}
		DetailProduit dp = DetailProduitRepo.save(p.getDetailProduit());
		
		return dp;
		
		
	}
	
	@Override
	@Transactional
	public Produit addProduit(Produit u, Long idRayon,Long idStock ) {
		u.setRayon(rayonRepository.findById(idRayon).get());
		u.setStock(StockRepository.findById(idStock).get());

		DetailProduit dp= saveDetailProduit(u);
		u.setDetailProduit(dp);
		produitRepository.save(u);
		
		return u;
	}
	

	@Override
	public void deleteProduit(String id) {

	produitRepository.deleteById(Long.parseLong(id));
			    
	}

	@Override
	public Produit updateProduit(Produit u) {
		long id= u.getIdProduit();
		Optional<Produit> produits = produitRepository.findById(id);

		if(produits!=null)
produitRepository.save(u);
		
		return u;
	}

	@Override
	public Produit retrieveProduit(long id) {

		Produit Produit = null;

		try {
			 Produit = produitRepository.findById(id).get();

		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
		
		return Produit;
	}

	
}
