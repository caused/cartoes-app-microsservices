package br.com.mastertech.pagamento.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastertech.pagamento.converter.PagamentoConverter;
import br.com.mastertech.pagamento.dto.FaturaDTO;
import br.com.mastertech.pagamento.dto.PagamentoDTO;
import br.com.mastertech.pagamento.entity.PagamentoEntity;
import br.com.mastertech.pagamento.exception.CartaoInativoException;
import br.com.mastertech.pagamento.exception.CartaoNaoExisteException;
import br.com.mastertech.pagamento.exception.PagamentoInexistenteException;
import br.com.mastertech.pagamento.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
	
	private PagamentoService service;
	private PagamentoConverter converter;
	
	public PagamentoController (PagamentoService service, PagamentoConverter converter) {
		this.service = service;
		this.converter = converter;
	}

	@PostMapping
	public ResponseEntity<PagamentoDTO> criarPagamento (@Valid @RequestBody PagamentoDTO pagamento) throws CartaoNaoExisteException, CartaoInativoException {
		PagamentoEntity pagamentoEntity = converter.convertFromDtoToEntity(pagamento);
		
		pagamentoEntity = service.criarPagamento(pagamentoEntity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(converter.convertFromEntityToDto(pagamentoEntity));
		
	}
	
	@GetMapping("/{id_cartao}")
	public List<PagamentoDTO> obterPagamentosDeUmCartao(@PathVariable(name = "id_cartao") Long id) throws CartaoNaoExisteException {
		List<PagamentoEntity> pagamentosList = this.service.obterPagamentoPorIdCartao(id);
		
		return pagamentosList
				.stream()
				.map(pagamento -> converter.convertFromEntityToDto(pagamento))
				.collect(Collectors.toList());
	}
	
	@DeleteMapping("/{id_cartao}")
	public FaturaDTO deletarPagamentosPorCartao(@PathVariable(name="id_cartao")Long cartaoId) throws PagamentoInexistenteException {
		return this.service.deletarPagamento(cartaoId);
	}
	
}
