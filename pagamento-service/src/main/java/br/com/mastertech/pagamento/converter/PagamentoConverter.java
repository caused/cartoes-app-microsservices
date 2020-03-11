package br.com.mastertech.pagamento.converter;

import org.springframework.stereotype.Component;

import br.com.mastertech.pagamento.dto.PagamentoDTO;
import br.com.mastertech.pagamento.entity.PagamentoEntity;
import br.com.mastertech.pagamento.exception.CartaoInativoException;
import br.com.mastertech.pagamento.exception.CartaoNaoExisteException;

@Component
public class PagamentoConverter {
	
	public PagamentoEntity convertFromDtoToEntity(PagamentoDTO dto) throws CartaoNaoExisteException, CartaoInativoException {
		
		PagamentoEntity entity = new PagamentoEntity();
		
		entity.setCartaoId(dto.getCartaoId());
		entity.setDecricao(dto.getDescricao());
		entity.setValor(dto.getValor());

		return entity;
	}
	
	public PagamentoDTO convertFromEntityToDto (PagamentoEntity entity) {
		PagamentoDTO dto = new PagamentoDTO();
	
		dto.setCartaoId(entity.getCartaoId());
		dto.setId(entity.getId());
		dto.setDescricao(entity.getDecricao());
		dto.setValor(entity.getValor());
		
		return dto;
	}
}
