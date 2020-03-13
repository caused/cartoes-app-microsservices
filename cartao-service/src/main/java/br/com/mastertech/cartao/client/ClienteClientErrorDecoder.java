package br.com.mastertech.cartao.client;

import br.com.mastertech.cartao.exception.ClienteNaoEncontradoException;
import br.com.mastertech.cartao.exception.ClienteOfflineException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteClientErrorDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		
		switch (response.status()) {
			case 404 :
				return new ClienteNaoEncontradoException("Favor informar um cliente que existe");
			default:
				return new ClienteOfflineException();
		}
		
	}

}
