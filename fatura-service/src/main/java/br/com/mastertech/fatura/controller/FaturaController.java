package br.com.mastertech.fatura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastertech.fatura.dto.CartaoDesativadoDTO;
import br.com.mastertech.fatura.dto.FaturaDTO;
import br.com.mastertech.fatura.dto.PagamentoDTO;
import br.com.mastertech.fatura.exception.CartaoNaoExisteException;
import br.com.mastertech.fatura.exception.CartaoNaoPertenceException;
import br.com.mastertech.fatura.exception.ClienteNaoEncontradoException;
import br.com.mastertech.fatura.exception.FaturaInexistenteException;
import br.com.mastertech.fatura.service.FaturaService;

@RestController
@RequestMapping("/fatura")
public class FaturaController {
	
	private FaturaService service;
	
	public FaturaController (FaturaService service) {
		this.service = service;
	}

	@GetMapping("/{cliente-id}/{cartao-id}")
	public List<PagamentoDTO> obterFatura (@PathVariable(value = "cliente-id") Long clienteId, @PathVariable(value="cartao-id") Long cartaoId) throws ClienteNaoEncontradoException, CartaoNaoPertenceException, CartaoNaoExisteException{
		return service.obterPagamentosDeUmCartao(clienteId, cartaoId);
	}
	
	@PostMapping("/{cliente-id}/{cartao-id}/pagar")
	public FaturaDTO pagarFatura (@PathVariable(value = "cliente-id") Long clienteId, @PathVariable(value="cartao-id") Long cartaoId) throws ClienteNaoEncontradoException, CartaoNaoPertenceException, FaturaInexistenteException, CartaoNaoExisteException{
		return service.pagarFatura(clienteId, cartaoId);
	}
	
	@PostMapping("/{cliente-id}/{cartao-id}/expirar")
	public CartaoDesativadoDTO bloquearCartao (@PathVariable(value = "cliente-id") Long clienteId, @PathVariable(value="cartao-id") Long cartaoId) throws ClienteNaoEncontradoException, CartaoNaoPertenceException, FaturaInexistenteException, CartaoNaoExisteException{
		return service.desativarCartao(clienteId, cartaoId);
	}
	
	
	
	
}
