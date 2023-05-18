package com.tutorial.stock.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_stock")
public class Stock {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long stockId;

	   
	    private String stockName;

	    private Double stockPrice;

	    private Integer stockOwnerCount;

	    
	    private String stockType;

	    private Double stockMarketCap;

	    private LocalDateTime stockCreatedTimeStamp;

}
