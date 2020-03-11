package br.com.mastertech.cartao.converter;

import org.springframework.stereotype.Component;


import br.com.mastertech.cartao.dto.CartaoDTO;
import br.com.mastertech.cartao.entity.CartaoEntity;

@Component
public class CartaoConverter {
	
	
	public CartaoEntity convertFromDtoToEntity (CartaoDTO dto){
		CartaoEntity entity = new CartaoEntity();
		
		entity.setCliente(dto.getClienteId());
		entity.setNumero(dto.getNumero());
		
		return entity;   
	}
	
	public CartaoDTO convertFromEntityToDto (CartaoEntity entity) {
		CartaoDTO dto = new CartaoDTO();
		
		dto.setAtivo(entity.getAtivo());
		dto.setClienteId(entity.getClienteId());
		dto.setNumero(entity.getNumero());
		dto.setId(entity.getId());
		
		return dto;
	}
}
