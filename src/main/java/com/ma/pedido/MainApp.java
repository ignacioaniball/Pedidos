package com.ma.pedido;

import com.ma.pedido.models.dao.ProductDao;
import com.ma.pedido.models.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class MainApp {

	private static final Logger logger= LoggerFactory.getLogger(MainApp.class); 
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductDao repositoProductoDao) {
		
		return (datos) -> {
			
			//save a few costumers
			logger.info("Populate the table producto");
			
			repositoProductoDao.save(new Product("Jamon y morrones", "Pizza con jamon y morrones", "Pizza con jamon y morrones", 550.00));
			repositoProductoDao.save(new Product("Palmitos", "Pizza con palmitos", "Pizza con palmitos", 600.00));
			
			logger.info(repositoProductoDao.findAll().toString());
		};
	}
}
