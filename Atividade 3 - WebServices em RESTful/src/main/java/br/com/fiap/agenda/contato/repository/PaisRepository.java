package br.com.fiap.agenda.contato.repository;

import br.com.fiap.agenda.contato.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, Long> {
}
