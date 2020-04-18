package com.invest.stock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invest.stock.model.Stock;

@RestController
public class StockServiceController {
   private static Map<String, Stock> stockRepo = new HashMap<>();
   static {
      Stock s1 = new Stock();
      s1.setSymbol("IBM");
      s1.setPrice("100");
      stockRepo.put(s1.getSymbol(), s1);

      Stock s2 = new Stock();
      s2.setSymbol("MSFT");
      s2.setPrice("158");
      stockRepo.put(s2.getSymbol(), s2);
   }

   @RequestMapping(value = "/stocks/{symbol}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("symbol") String symbol) {
      stockRepo.remove(symbol);
      return new ResponseEntity<>("stock is deleted successsfully", HttpStatus.OK);
   }

   @RequestMapping(value = "/stocks/{symbol}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("symbol") String symbol, @RequestBody Stock stock) {
     stockRepo.remove(symbol);
      stock.setSymbol(symbol);
      stockRepo.put(symbol, stock);
      return new ResponseEntity<>("stocks is updated successsfully", HttpStatus.OK);
   }

   @RequestMapping(value = "/stocks", method = RequestMethod.POST)
   public ResponseEntity<Object> createStock(@RequestBody Stock stock) {
      stockRepo.put(stock.getSymbol(), stock);
      return new ResponseEntity<>("stocks is created successfully", HttpStatus.CREATED);
   }

   @CrossOrigin(origins = "http://localhost:8001")
   @RequestMapping(value = "/stocks")
   public ResponseEntity<Object> getStocks() {
      return new ResponseEntity<>(stockRepo.values(), HttpStatus.OK);
   }
}