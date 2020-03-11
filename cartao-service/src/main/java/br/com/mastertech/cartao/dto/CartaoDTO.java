package br.com.mastertech.cartao.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartaoDTO {

	private Long id;
	
	@NotNull(message = "Id do cliente não pode ser nulo")
	private Long clienteId;
	
	@NotNull(message = "Número do cartão não pode ser nulo")
	@NotBlank(message = "Favor informar um numero de cartao")
	private String numero;
	private Boolean ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
