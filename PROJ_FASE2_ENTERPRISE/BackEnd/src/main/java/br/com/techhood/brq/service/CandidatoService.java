package br.com.techhood.brq.service;

import br.com.techhood.brq.entity.CandidatoCertificadoEntity;
import br.com.techhood.brq.entity.CandidatoEntity;
import br.com.techhood.brq.entity.CandidatoSkillEntity;

import java.util.List;

public interface CandidatoService {

    List<CandidatoEntity> findAll();

    CandidatoEntity findById(Long id);

    List<CandidatoEntity> findBy(CandidatoEntity candidatoEntityBuscar);

    CandidatoEntity create(CandidatoEntity candidatoEntity);

    CandidatoEntity save(CandidatoEntity candidatoEntity);

    void delete(Long id);

    List<CandidatoEntity> findCandidatosBySkillId(Long id);

    void createSkill(CandidatoSkillEntity candidatoSkillEntity);

    void createSkills(Long id, List<CandidatoSkillEntity> candidatoSkillEntities);

    void deleteSkill(CandidatoSkillEntity candidatoSkillEntity);

    void deleteSkillsByCandidateId(Long id);

    void deleteBySkillId(Long id);

    void createCertified(CandidatoCertificadoEntity candidatoCertificadoEntity);

    void createCertifieds(Long id, List<CandidatoCertificadoEntity> candidatoCertificadoEntities);

    void deleteCertified(CandidatoCertificadoEntity candidatoCertificadoEntity);

    void deleteCertifiedssByCandidateId(Long id);
}
