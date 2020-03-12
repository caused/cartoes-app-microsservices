package br.com.mastertech.cartao.client;

import org.springframework.stereotype.Component;

import br.com.mastertech.cartao.dto.ClienteDTO;

@Component
public class ClienteFallback implements ClienteClient{

	@Override
	public ClienteDTO getClienteById(Long id) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Favor informar cliente existente");
	}

}
