package br.com.mastertech.cartao.exception;

public class CartaoExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5806865527383642106L;

	private String mensagem;
	
	public CartaoExistenteException(String mensagem) {
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
