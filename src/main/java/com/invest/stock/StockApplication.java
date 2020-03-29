package com.invest.stock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class StockApplication {

  @Value("${spring.application.name}")
   private String name;
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}


}
