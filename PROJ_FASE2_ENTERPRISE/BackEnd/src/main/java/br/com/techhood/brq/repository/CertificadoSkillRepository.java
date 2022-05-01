package br.com.techhood.brq.repository;

import br.com.techhood.brq.entity.CertificadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificadoSkillRepository extends JpaRepository<CertificadoEntity, Long> {

    @Query("SELECT c FROM CertificadoEntity c WHERE c.skill.id = :id")
    List<CertificadoEntity> findBySkillId(@Param("id") Long id);
}
