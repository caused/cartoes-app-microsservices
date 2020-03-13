package br.com.mastertech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mastertech.cartao.client.ClienteClientErrorDecoder;

@Configuration
public class ClienteConfiguration {

	@Bean
	public ClienteClientErrorDecoder clienteClientErrorDecoder() {
		return new ClienteClientErrorDecoder();
	}
}
