package br.com.techhood.brq.repository;

import br.com.techhood.brq.entity.CandidatoSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CandidatoSkillRepository extends JpaRepository<CandidatoSkillEntity, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM CandidatoSkillEntity cs WHERE cs.candidato.id = :id")
    void deleteSkillByCandidatoId(@Param("id") Long id);
}
