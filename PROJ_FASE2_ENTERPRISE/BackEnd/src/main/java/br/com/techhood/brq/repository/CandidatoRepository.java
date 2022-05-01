package br.com.techhood.brq.repository;

import br.com.techhood.brq.entity.CandidatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoEntity, Long>, JpaSpecificationExecutor {

    @Query("SELECT c FROM CandidatoEntity c INNER JOIN CandidatoSkillEntity ck ON c.id = ck.candidato.id WHERE ck.skill.nome IN :skillNomes")
    List<CandidatoEntity> findCandidatosBySkillNomes(@Param("skillNomes") Collection<String> skillNomes);

    @Query("SELECT c FROM CandidatoEntity c INNER JOIN CandidatoSkillEntity ck ON c.id = ck.candidato.id WHERE ck.skill.id = :id")
    List<CandidatoEntity> findCandidatosBySkillId(@Param("id") Long id);
}
