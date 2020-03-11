package br.com.mastertech.pagamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import br.com.mastertech.pagamento.entity.PagamentoEntity;

public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long>{

	@Nullable
	@Query("select p from PagamentoEntity p where p.cartaoId = :id")
	public List<PagamentoEntity> findByCartao(Long id);
}
