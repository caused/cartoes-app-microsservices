package br.com.mastertech.cliente.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mastertech.cliente.entity.ClienteEntity;
import br.com.mastertech.cliente.exception.ClienteNaoEncontradoException;
import br.com.mastertech.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public ClienteEntity criar(ClienteEntity cliente) {
		return repository.save(cliente);
	}
	
	public ClienteEntity obterClientePorId(Long id) throws ClienteNaoEncontradoException {
		Optional<ClienteEntity> clienteOptional = repository.findById(id);
		
		if(!clienteOptional.isPresent()) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado");
		}
		
		return clienteOptional.get();
	}
}
