package br.com.fiap.agenda.contato.repository;

import br.com.fiap.agenda.contato.entity.TipoTelefoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTelefoneRepository extends JpaRepository<TipoTelefoneEntity, Long> {
}
