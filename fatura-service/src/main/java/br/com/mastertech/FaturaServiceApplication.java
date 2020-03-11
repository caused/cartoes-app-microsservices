package br.com.mastertech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FaturaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaturaServiceApplication.class, args);
	}

}
