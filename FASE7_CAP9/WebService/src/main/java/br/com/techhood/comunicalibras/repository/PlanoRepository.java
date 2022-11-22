package br.com.techhood.comunicalibras.repository;

import br.com.techhood.comunicalibras.entity.PlanoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<PlanoEntity, Long> {
}
