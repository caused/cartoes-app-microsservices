package br.com.mastertech.pagamento.client;

import br.com.mastertech.pagamento.exception.CartaoInativoException;
import br.com.mastertech.pagamento.exception.CartaoNaoExisteException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CartaoClientErrorDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		System.out.println("Chamou o decoder: " + response.status());
		switch(response.status()) {
		case 404:
			return new CartaoNaoExisteException("Favor informar um cartão existente");
		case 400:
			return new CartaoInativoException("Favor informar um cartão ativo");
		default:
			return new RuntimeException("Erro interno no serviço de cartões");
		}

	}

}
