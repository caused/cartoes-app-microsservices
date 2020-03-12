package br.com.mastertech.cartao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.mastertech.cartao.dto.ClienteDTO;

@FeignClient(name = "cliente-service", fallback = ClienteFallback.class)
public interface ClienteClient {

	@GetMapping("/cliente/{id}")
	ClienteDTO getClienteById (@PathVariable Long id);
}
