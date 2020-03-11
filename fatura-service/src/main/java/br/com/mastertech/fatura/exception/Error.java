package br.com.mastertech.fatura.exception;
public class Error {

	private String mensagem;
	
	public Error(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
