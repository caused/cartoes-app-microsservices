package br.com.mastertech.cartao.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mastertech.cartao.client.ClienteClient;
import br.com.mastertech.cartao.dto.AtivarCartaoDTO;
import br.com.mastertech.cartao.dto.ClienteDTO;
import br.com.mastertech.cartao.entity.CartaoEntity;
import br.com.mastertech.cartao.exception.CartaoExistenteException;
import br.com.mastertech.cartao.exception.CartaoNaoExisteException;
import br.com.mastertech.cartao.exception.ClienteNaoEncontradoException;
import br.com.mastertech.cartao.repository.CartaoRepository;
import feign.FeignException;

@Service
public class CartaoService {

	private CartaoRepository cartaoRepository;
	private ClienteClient client;

	public CartaoService (CartaoRepository repository,ClienteClient client) {
		this.cartaoRepository = repository;
		this.client = client;
	}

	public CartaoEntity criarCartao(CartaoEntity cartao) throws CartaoExistenteException, ClienteNaoEncontradoException{
		ClienteDTO clienteDTO = null;
		try {
			clienteDTO = client.getClienteById(cartao.getClienteId());
		}catch (FeignException.FeignClientException.NotFound e) {
			throw new ClienteNaoEncontradoException("Favor escolher um cliente existente");
		}
		
		cartao.setCliente(clienteDTO.getId());
		cartao.setAtivo(Boolean.FALSE);
		
		CartaoEntity cartaoEntity = cartaoRepository.findByNumero(cartao.getNumero());
		
		if(!Objects.isNull(cartaoEntity)) {
			throw new CartaoExistenteException("Este número de cartão já está em uso");
		}

		return this.cartaoRepository.save(cartao);

	}

	public CartaoEntity ativarCartao(String numero, AtivarCartaoDTO cartao) throws CartaoNaoExisteException {

		CartaoEntity cartaoEntity = cartaoRepository.findByNumero(numero);

		if(Objects.isNull(cartaoEntity)) {
			throw new CartaoNaoExisteException("Favor informar um cartão existente para ativar");
		}else {
			cartaoEntity.setAtivo(cartao.getAtivo());
			return cartaoRepository.save(cartaoEntity);
		}

	}

	public CartaoEntity obterPorNumero(String numero) throws CartaoNaoExisteException {
		CartaoEntity cartaoEntity = cartaoRepository.findByNumero(numero);

		if(Objects.isNull(cartaoEntity)) {
			throw new CartaoNaoExisteException("Este cartão não existe");
		}else {
			return cartaoEntity;
		}


	}

	public CartaoEntity obterPorId(Long cartaoId) throws CartaoNaoExisteException {
		Optional<CartaoEntity> optional = cartaoRepository.findById(cartaoId);

		if(!optional.isPresent()) {
			throw new CartaoNaoExisteException("Este cartão não existe");
		}else {
			return optional.get();
		}
	}
	
	public void desativarCartao(Long cartaoId) throws CartaoNaoExisteException {
		Optional<CartaoEntity> optional = cartaoRepository.findById(cartaoId);
		
		if(!optional.isPresent()) {
			throw new CartaoNaoExisteException("Este cartão não existe");
		}else {
			CartaoEntity entity = optional.get();
			entity.setAtivo(Boolean.FALSE);
			
			cartaoRepository.save(entity);
		}
	}

}
