package br.com.mastertech.fatura.exception;
public class CartaoInativoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8340929093810538994L;
	private String mensagem;
	
	public CartaoInativoException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
