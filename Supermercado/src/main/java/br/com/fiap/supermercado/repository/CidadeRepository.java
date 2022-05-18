package br.com.fiap.supermercado.repository;

import br.com.fiap.supermercado.entity.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> {
}
