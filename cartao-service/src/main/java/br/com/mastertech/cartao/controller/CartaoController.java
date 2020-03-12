package br.com.mastertech.cartao.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastertech.cartao.converter.CartaoConverter;
import br.com.mastertech.cartao.dto.AtivarCartaoDTO;
import br.com.mastertech.cartao.dto.CartaoDTO;
import br.com.mastertech.cartao.dto.CartaoDesativadoDTO;
import br.com.mastertech.cartao.entity.CartaoEntity;
import br.com.mastertech.cartao.exception.CartaoExistenteException;
import br.com.mastertech.cartao.exception.CartaoNaoExisteException;
import br.com.mastertech.cartao.exception.ClienteNaoEncontradoException;
import br.com.mastertech.cartao.service.CartaoService;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
	
	private CartaoService service;
	private CartaoConverter converter;
	
	public CartaoController (CartaoService service, CartaoConverter converter) {
		this.service = service;
		this.converter = converter;
	}

	@PostMapping
	public ResponseEntity<CartaoDTO> criarCartao (@Valid @RequestBody CartaoDTO cartao) throws ClienteNaoEncontradoException, CartaoExistenteException {
		CartaoEntity entity = this.converter.convertFromDtoToEntity(cartao);
		
		CartaoEntity cartaoEntity = service.criarCartao(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(converter.convertFromEntityToDto(cartaoEntity));
	}
	
	@PatchMapping("/{numero}")
	public ResponseEntity<CartaoDTO> ativarCartao (@PathVariable String numero, @RequestBody AtivarCartaoDTO cartao) throws CartaoNaoExisteException{
		CartaoEntity cartaoEntity = this.service.ativarCartao(numero, cartao);
		
		return ResponseEntity.ok(converter.convertFromEntityToDto(cartaoEntity));
	}
	
	@GetMapping("/{numero}")
	public ResponseEntity<CartaoDTO> obterCartaoPorNumero (@PathVariable String numero) throws CartaoNaoExisteException {
		CartaoEntity cartaoEntity = this.service.obterPorNumero(numero);
		
		return ResponseEntity.ok(converter.convertFromEntityToDto(cartaoEntity));
	}
	
	@GetMapping("/obter/{id}")
	public ResponseEntity<CartaoDTO> obterCartaoPorId (@PathVariable Long id) throws CartaoNaoExisteException{
		CartaoEntity cartaoEntity = this.service.obterPorId(id);
		
		return ResponseEntity.ok(converter.convertFromEntityToDto(cartaoEntity));
	}
	
	@PostMapping("/desativar/{cartaoId}")
	public ResponseEntity<CartaoDesativadoDTO> desativarCartao (@PathVariable Long cartaoId) throws CartaoNaoExisteException {
		this.service.desativarCartao(cartaoId);
		
		return ResponseEntity.ok(new CartaoDesativadoDTO("ok"));
	}
	
}
