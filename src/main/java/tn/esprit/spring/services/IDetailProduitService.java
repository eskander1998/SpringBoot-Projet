package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entites.*;

public interface IDetailProduitService {
	 List<DetailProduit> retrieveAllDetailProduit();
	 long addDetailProduit(DetailProduit u);
	 void deleteDetailProduit(String id);
	 DetailProduit updateDetailProduit(DetailProduit u);
	 DetailProduit retrieveDetailProduit(long id);
}
