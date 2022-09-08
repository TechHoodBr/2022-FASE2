package br.com.techhood.comunicalibras.repository;

import br.com.techhood.comunicalibras.entity.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<AulaEntity, Long> {
}
