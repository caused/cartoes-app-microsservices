package br.com.mastertech.fatura.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.mastertech.fatura.dto.ClienteDTO;

@FeignClient(name = "cliente-service")
public interface ClienteClient {

	@GetMapping("/cliente/{clienteId}")
	ClienteDTO obterClientePorId(@PathVariable Long clienteId);
}
