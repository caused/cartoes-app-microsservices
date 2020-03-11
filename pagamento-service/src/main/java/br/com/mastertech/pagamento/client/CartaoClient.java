package br.com.mastertech.pagamento.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.mastertech.pagamento.dto.CartaoDTO;

@FeignClient(name = "cartao-service")
public interface CartaoClient {

	@GetMapping("/cartao/obter/{id}")
	CartaoDTO obterCartaoPorId(@PathVariable Long id);
}
