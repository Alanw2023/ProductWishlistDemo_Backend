package io.guidemy.learn.productwishlistdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProductWishlistDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductWishlistDemoApplication.class, args);
	}

}
