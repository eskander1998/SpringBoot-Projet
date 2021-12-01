package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entites.*;

public interface IDetailFactureService {
	 List<DetailFacture> retrieveAllDetailFacture();
	 long addDetailFacture(DetailFacture u);
	 void deleteDetailFacture(String id);
	 DetailFacture updateDetailFacture(DetailFacture u);
	 DetailFacture retrieveDetailFacture(long id);
}
