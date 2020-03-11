package br.com.mastertech.fatura.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mastertech.fatura.client.CartaoClient;
import br.com.mastertech.fatura.client.ClienteClient;
import br.com.mastertech.fatura.client.PagamentoClient;
import br.com.mastertech.fatura.dto.CartaoDTO;
import br.com.mastertech.fatura.dto.ClienteDTO;
import br.com.mastertech.fatura.dto.PagamentoDTO;
import br.com.mastertech.fatura.exception.CartaoNaoPertenceException;
import br.com.mastertech.fatura.exception.ClienteNaoEncontradoException;
import feign.FeignException;

@Service
public class FaturaService {

	private ClienteClient clienteClient;
	private CartaoClient cartaoClient;
	private PagamentoClient pagamentoClient;
	
	public FaturaService(ClienteClient clienteClient, CartaoClient cartaoClient, PagamentoClient pagamentoClient) {
		this.clienteClient = clienteClient;
		this.cartaoClient = cartaoClient;
		this.pagamentoClient = pagamentoClient;
	}
	
	public List<PagamentoDTO> obterPagamentosDeUmCartao(Long clienteId, Long cartaoId) throws ClienteNaoEncontradoException, CartaoNaoPertenceException{
		ClienteDTO cliente = null;
		CartaoDTO cartao = null;
		try {
			cliente = clienteClient.obterClientePorId(clienteId);
		}catch(FeignException.FeignClientException.NotFound e) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado");
		}
		
		try {
			cartao = cartaoClient.obterCartaoPorId(cartaoId);
		}catch(FeignException.FeignClientException.BadRequest e) {
			throw new ClienteNaoEncontradoException("Cartão não encontrado");
		}
		
		if(cliente.getId() != cartao.getClienteId()) {
			throw new CartaoNaoPertenceException("Este cartão não pertence a este cliente");
		}
		
		return pagamentoClient.obterPagamentoPorIdCartao(cartaoId);
		
	}
	
	
}
