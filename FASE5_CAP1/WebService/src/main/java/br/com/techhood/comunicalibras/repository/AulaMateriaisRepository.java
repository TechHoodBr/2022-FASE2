package br.com.techhood.comunicalibras.repository;

import br.com.techhood.comunicalibras.entity.AulaMateriaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaMateriaisRepository extends JpaRepository<AulaMateriaisEntity, Long> {
}
