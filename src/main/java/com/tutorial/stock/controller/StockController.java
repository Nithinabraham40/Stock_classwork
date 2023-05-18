package com.tutorial.stock.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.stock.model.Stock;
import com.tutorial.stock.service.StockService;

@RestController
@RequestMapping( "/stock")
	public class StockController {

	    @Autowired
	  private  StockService stockService;
	    
	    
	    @PostMapping("/addstock")
	    public String insertStocks(@RequestBody List<Stock> stockList)
	    {
	        return stockService.addStocks(stockList);
	    }
	    
	    @GetMapping( "price/{price}/date/{date}")
	    public List<Stock> getStocksByPriceAndDate(@PathVariable Double price,@PathVariable LocalDateTime date)
	    {
	        return stockService.getStocksByPriceAndDate(price,date);
	    }
	    
	    @PutMapping( "/marketCap/{marketCap}/id/{id}")
	    public void insertStocks(@PathVariable Double marketCap, @PathVariable Long id)
	    {
	         stockService.updateMarketCap(marketCap,id);
	    }
	    
	    @DeleteMapping("/ownerCount/{count}")
	    public void removeStocksByOwnerCount(@PathVariable  Integer count)
	    {
	        stockService.deleteStocksBasedOnOwnerCount(count);
	    }
}
