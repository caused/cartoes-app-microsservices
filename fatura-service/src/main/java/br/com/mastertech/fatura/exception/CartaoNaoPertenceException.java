package br.com.mastertech.fatura.exception;

public class CartaoNaoPertenceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public CartaoNaoPertenceException (String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}

}
