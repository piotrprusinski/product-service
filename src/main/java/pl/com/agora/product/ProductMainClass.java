package pl.com.agora.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import pl.com.agora.api.payment.client.PaymentClient;
import pl.com.agora.api.payment.client.PaymentClientProvider;

@EnableAutoConfiguration
@ComponentScan
public class ProductMainClass {
	public static void main(String[] args) {
		SpringApplication.run(ProductMainClass.class, args);
	}
	
	@Bean
	public PaymentClient paymentClient(@Value("${payment.serviceHost}") String serviceHost, @Value("${payment.servicePort}") int servicePort) throws Exception {
		return new PaymentClientProvider().create(serviceHost, servicePort);
	}
}
