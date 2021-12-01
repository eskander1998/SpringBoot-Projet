package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.DAO.entites.*;

public interface IStockService {
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);

}
