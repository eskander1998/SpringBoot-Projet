package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.util.FixedDelay;
import tn.esprit.spring.DAO.entites.*;
import tn.esprit.spring.repository.*;

public class StockServiceImp implements IStockService{
	
	@Autowired
	StockRepository StockRepository ;
	
	@Override
	public List<Stock> retrieveAllStocks() {
		   List<Stock> stocks = (List<Stock>) StockRepository.findAll();
	        for(Stock stock :stocks)
	        {
	        	 System.out.println("stock +++" + stock);
	    }return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		StockRepository.save(s);
	        return s;
	}

	@Override
	public Stock updateStock(Stock s) {

	    Optional <Stock> stocks = StockRepository.findById(s.getIdStock());
	   
	    
	    if(stocks!= null) 
	    	StockRepository.save(s);
	    
		return s;
	}

	@Override
	public Stock retrieveStock(Long id) {
		StockRepository.findById(id);
			return null;
	}
	
	
}

