package com.tutorial.stock.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tutorial.stock.model.Stock;

import jakarta.transaction.Transactional;

public interface StockRepo extends JpaRepository<Stock, Long>{

	

	@Query(
			value="select * from tbl_stock where stock_price=:price and stock_created_time_stamp=:date",
			nativeQuery = true
			)
	
	List<Stock> getStocksByPriceAndDate(Double price, LocalDateTime date);

	
	@Modifying
	@Transactional
	@Query(
			value = "update tbl_stock set stock_market_cap=:marketCap where stock_id=:id",
			nativeQuery = true
			)
	
	void updateMarketCap(Double marketCap, Long id);

	
	@Modifying
	@Transactional
	@Query(
			value="delete from tbl_stock where stock_owner_count<=:count",
			nativeQuery = true
			)
	

	void deleteByStockOwnerCount(Integer count);

}
