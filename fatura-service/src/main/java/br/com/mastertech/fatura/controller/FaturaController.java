package br.com.mastertech.fatura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastertech.fatura.dto.PagamentoDTO;
import br.com.mastertech.fatura.exception.CartaoNaoPertenceException;
import br.com.mastertech.fatura.exception.ClienteNaoEncontradoException;
import br.com.mastertech.fatura.service.FaturaService;

@RestController
@RequestMapping("/fatura")
public class FaturaController {
	
	private FaturaService service;
	
	public FaturaController (FaturaService service) {
		this.service = service;
	}

	@GetMapping("/{cliente-id}/{cartao-id}")
	public List<PagamentoDTO> obterFatura (@PathVariable(value = "cliente-id") Long clienteId, @PathVariable(value="cartao-id") Long cartaoId) throws ClienteNaoEncontradoException, CartaoNaoPertenceException{
		return service.obterPagamentosDeUmCartao(clienteId, cartaoId);
	}
}