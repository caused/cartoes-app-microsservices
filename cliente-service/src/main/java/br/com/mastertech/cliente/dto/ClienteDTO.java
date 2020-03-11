package br.com.mastertech.cliente.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDTO {

	private Long id;
	
	@NotNull(message = "Nome do cliente não pode ser nulo")
	@NotBlank (message = "Favor informar o nome do cliente")
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
