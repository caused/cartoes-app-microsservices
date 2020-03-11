package br.com.mastertech.pagamento.exception;

public class PagamentoInexistenteException extends Exception {

	private String mensagem;
	
	private static final long serialVersionUID = -775495073323921570L;

	public PagamentoInexistenteException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMensagem () {
		return this.mensagem;
	}
}
