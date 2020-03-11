package br.com.mastertech.fatura.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PagamentoDTO {

	private Long id;
	@JsonProperty("cartao_id")
	private Long cartaoId;
	private String descricao;
	private BigDecimal valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCartaoId() {
		return cartaoId;
	}
	public void setCartaoId(Long cartaoId) {
		this.cartaoId = cartaoId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
