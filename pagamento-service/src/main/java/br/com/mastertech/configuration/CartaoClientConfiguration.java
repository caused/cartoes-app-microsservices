package br.com.mastertech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mastertech.pagamento.client.CartaoClientErrorDecoder;

@Configuration
public class CartaoClientConfiguration {

	@Bean
	public CartaoClientErrorDecoder cartaoClientErrorDecoder() {
		return new CartaoClientErrorDecoder();
	}
}
