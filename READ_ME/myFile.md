# Welcome to readme-md-generator &#x1F44B; 
![example workflow](https://img.shields.io/badge/Eclipse-Version%3A%202022--09%20(4.25.0)-orange)
![example workflow](https://img.shields.io/badge/SpringBoot-2.2.1-yellowgreen)
![example workflow](https://img.shields.io/badge/Java-8-yellowgreen)
![example workflow](https://img.shields.io/badge/Postman-v10.13-orange)
![example workflow](https://img.shields.io/badge/Documentation-Yes-green)
![example workflow](https://img.shields.io/badge/Manitained%3F-Yes-green)
 >CLI that generate beautiful **ReadME**.md files

  :house:  <b><span style="color: blue;">Homepage</span></b>
  


 # Prerequisties

 - **Eclipse >=4.55.0**
 - **Postman >=10.13**
 


# Install
```
Maven Install
SpringTool Install
```
 # Framework And Language

 - **Framework :  SpringBoot**
 - **Language :  Java**

 # Dependencies Required

 
 - **spring-boot-starter-web**
 - **spring-boot-devtools**
 - **spring-boot-starter-data-jpa**
 - **mysql-connector**
 - **lambok**

 - **spring-boot-starter-test**
 


# Model


```


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
	
	
```


#  Controller


```

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
	
```

#  Service


```

@Service
public class StockService {
	
	
	@Autowired
	private StockRepo stockRepo;

	public String addStocks(List<Stock> stockList) {

	         Iterable<Stock> list = stockRepo.saveAll(stockList);
	         if(list!=null){
	         
	             return "Added stock";}
	         
	           return "Not added";
	         
	    
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
	
```


#  Repository


```
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


	
	
	


	
```

	
	


  


	







	



# DataBase Used

<details>
<summary><b><span style="color: white;">Clickme</span></b> &#x1F4F2; </summary>

*Mysql*



</details>



  




# Summary

 Spring boot Stock managment project using Mysql us database  .
These project will have the following features
**addstock**,
**get stock by price and date**,
**update marketcap by id**,
**delete stock by ownercount**
.






# :handshake:  Contributing
  Contributions,issues and features request are welcome! 
  

  #


  This *README* was generated with &#x2764;&#xFE0F; by <b><span style="color: blue;">readme-md-generator</span></b> 










   
  
  

