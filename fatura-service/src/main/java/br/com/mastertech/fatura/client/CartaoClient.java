package br.com.mastertech.fatura.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.mastertech.fatura.dto.CartaoDTO;

@FeignClient(name = "cartao-service")
public interface CartaoClient {

	@GetMapping("/cartao/obter/{id}")
	CartaoDTO obterCartaoPorId(@PathVariable Long id);

}
