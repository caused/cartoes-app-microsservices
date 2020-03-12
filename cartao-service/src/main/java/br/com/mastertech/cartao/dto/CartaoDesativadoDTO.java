package br.com.mastertech.cartao.dto;

public class CartaoDesativadoDTO {

	private String status;

	public CartaoDesativadoDTO() {
		super();
	}
	
	public CartaoDesativadoDTO (String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
