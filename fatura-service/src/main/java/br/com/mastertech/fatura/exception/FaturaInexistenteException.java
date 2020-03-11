package br.com.mastertech.fatura.exception;

public class FaturaInexistenteException extends Exception {

	private String mensagem;

	private static final long serialVersionUID = -775495034323921570L;

	public FaturaInexistenteException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}

	public String getMensagem () {
		return this.mensagem;
	}
}
