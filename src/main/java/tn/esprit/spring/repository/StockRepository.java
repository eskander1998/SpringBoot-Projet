package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entites.Stock;
@Repository

public interface StockRepository extends CrudRepository<Stock,Long>{

}
