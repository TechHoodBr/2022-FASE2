package br.com.techhood.brq.repository;

import br.com.techhood.brq.entity.CandidatoCertificadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CandidatoCertificadoRepository extends JpaRepository<CandidatoCertificadoEntity, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM CandidatoCertificadoEntity cc WHERE cc.certificado.id = :id")
    void deleteByCertifiedId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM CandidatoCertificadoEntity cs WHERE cs.candidato.id = :id")
    void deleteCertifiedsByCandidatoId(@Param("id") Long id);
}
