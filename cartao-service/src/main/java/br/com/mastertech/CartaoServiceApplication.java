package br.com.mastertech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

import br.com.mastertech.configuration.RibbonConfiguration;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class CartaoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartaoServiceApplication.class, args);
	}

}
