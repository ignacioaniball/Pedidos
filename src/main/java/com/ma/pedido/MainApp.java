package com.ma.pedido;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainApp {

	private static final Logger logger= LoggerFactory.getLogger(MainApp.class); 
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	/*
	@Bean
	public CommandLineRunner demo(ProductoDao repositoProductoDao) {
		
		return (datos) -> {
			
			//save a few costumers
			logger.info("Populate the table producto");
			
			repositoProductoDao.save(new Producto("Jamon y morrones", "Pizza con jamon y morrones", "Pizza con jamon y morrones", 550));
			repositoProductoDao.save(new Producto("Palmitos", "Pizza con palmitos", "Pizza con palmitos", 600));
			
			logger.info(repositoProductoDao.findAll().toString());
		};
	}
*/
}
