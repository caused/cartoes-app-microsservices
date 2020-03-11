package br.com.mastertech.fatura.exception;
public class ClienteNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	
	private String mensagem;
	
	private static final long serialVersionUID = -775495078323921570L;

	public ClienteNaoEncontradoException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMensagem () {
		return this.mensagem;
	}
}
