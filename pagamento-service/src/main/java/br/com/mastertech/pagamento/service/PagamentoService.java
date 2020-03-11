package br.com.mastertech.pagamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mastertech.pagamento.client.CartaoClient;
import br.com.mastertech.pagamento.dto.CartaoDTO;
import br.com.mastertech.pagamento.entity.PagamentoEntity;
import br.com.mastertech.pagamento.exception.CartaoInativoException;
import br.com.mastertech.pagamento.exception.CartaoNaoExisteException;
import br.com.mastertech.pagamento.repository.PagamentoRepository;
import feign.FeignException;

@Service
public class PagamentoService {

	private PagamentoRepository repository;
	private CartaoClient client;

	public PagamentoService (PagamentoRepository repository,CartaoClient client ) {
		this.repository = repository;
		this.client = client;
	}

	public PagamentoEntity criarPagamento (PagamentoEntity pagamento) throws CartaoNaoExisteException, CartaoInativoException {
		CartaoDTO cartaoDTO = null;
		try {
			cartaoDTO = client.obterCartaoPorId(pagamento.getCartaoId());
		}catch(FeignException.FeignServerException.BadRequest e) {
			throw new CartaoNaoExisteException("Escolha um cartão existente");
		}
		if(!cartaoDTO.getAtivo()) {
			throw new CartaoInativoException("Favor escolher um cartão ativo");
		}
		pagamento.setCartaoId(cartaoDTO.getId());
		

		return repository.save(pagamento);

	}

	public List<PagamentoEntity> obterPagamentoPorIdCartao (Long id) throws CartaoNaoExisteException{
		List<PagamentoEntity> listaPagamentos = repository.findByCartao(id);

		if(listaPagamentos == null) {
			throw new CartaoNaoExisteException("Favor lançar o pagamento em um cartão existente");
		}

		return listaPagamentos;
	}
}
