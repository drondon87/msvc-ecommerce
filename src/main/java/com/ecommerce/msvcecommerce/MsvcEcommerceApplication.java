package com.ecommerce.msvcecommerce;

import com.ecommerce.msvcecommerce.domain.port.data.EcommerceData;
import com.ecommerce.msvcecommerce.infraestructure.entities.Price;
import com.ecommerce.msvcecommerce.domain.port.repositories.PriceRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Msvc-Ecommerce microservice REST API Documentation",
		description = "Ecommerce microservices REST API Documentation",
		version = "v1",
		contact = @Contact(name = "Domingo Rondon", email = "domingorondon87@gmail.com")))
public class MsvcEcommerceApplication implements CommandLineRunner {

	@Autowired
	private PriceRepository priceRepositoy;

	public static void main(String[] args) {
		SpringApplication.run(MsvcEcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Price> prices = EcommerceData.getListPrices();
		prices.forEach(priceRepositoy::save);
	}

}
