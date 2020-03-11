package br.com.mastertech.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import br.com.mastertech.cartao.entity.CartaoEntity;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Long>{
	
	@Nullable
	public CartaoEntity findByNumero (String numero);

}
