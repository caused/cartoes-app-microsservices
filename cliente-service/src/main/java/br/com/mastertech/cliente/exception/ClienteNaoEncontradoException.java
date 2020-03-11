package br.com.mastertech.cliente.exception;

public class ClienteNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5655225439190054953L;

	private String mensagem;
	
	public ClienteNaoEncontradoException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
}
