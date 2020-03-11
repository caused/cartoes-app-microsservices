package br.com.mastertech.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mastertech.cliente.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
