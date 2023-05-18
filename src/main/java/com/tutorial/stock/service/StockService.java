package com.tutorial.stock.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.stock.model.Stock;
import com.tutorial.stock.repository.StockRepo;
@Service
public class StockService {
	
	
	@Autowired
	private StockRepo stockRepo;

	public String addStocks(List<Stock> stockList) {
		
		

	         Iterable<Stock> list = stockRepo.saveAll(stockList);
	         if(list!=null)
	         {
	             return "Added stock";
	         }
	         else
	         {
	             return "Not added";
	         }
	    
	}

	 

	public List<Stock> getStocksByPriceAndDate(Double price, LocalDateTime date) {
		
		return stockRepo.getStocksByPriceAndDate(price,date);
	}



	public void updateMarketCap(Double marketCap, Long id) {
		
		 stockRepo.updateMarketCap(marketCap,id);
		
	}



	public void deleteStocksBasedOnOwnerCount(Integer count) {
		stockRepo.deleteByStockOwnerCount(count);
		
	}
	
	

}
