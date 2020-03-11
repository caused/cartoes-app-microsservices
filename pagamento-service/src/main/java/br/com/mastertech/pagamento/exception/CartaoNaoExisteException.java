package br.com.mastertech.pagamento.exception;

public class CartaoNaoExisteException extends Exception {

	/**
	 * 
	 */
	private String mensagem;
	
	private static final long serialVersionUID = 5341392302871870379L;
	
	public CartaoNaoExisteException (String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}

}
