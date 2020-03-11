package br.com.mastertech.fatura.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.mastertech.fatura.dto.FaturaDTO;
import br.com.mastertech.fatura.dto.PagamentoDTO;

@FeignClient(name = "pagamento-service")
public interface PagamentoClient {

	@GetMapping("/pagamento/{id_cartao}")
	List<PagamentoDTO> obterPagamentoPorIdCartao(@PathVariable(name="id_cartao") Long cartaoId);
	
	@DeleteMapping("/pagamento/{id_cartao}")
	FaturaDTO pagarFatura (@PathVariable(name="id_cartao")Long cartaoId);
}
