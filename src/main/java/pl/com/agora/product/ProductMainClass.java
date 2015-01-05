package pl.com.agora.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class ProductMainClass {
	public static void main(String[] args) {
		SpringApplication.run(ProductMainClass.class, args);
	}
}
