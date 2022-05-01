package br.com.techhood.brq.service.impl;

import br.com.techhood.brq.entity.*;
import br.com.techhood.brq.repository.CandidatoCertificadoRepository;
import br.com.techhood.brq.repository.CandidatoRepository;
import br.com.techhood.brq.repository.CandidatoSkillRepository;
import br.com.techhood.brq.service.CandidatoService;
import br.com.techhood.brq.specification.CandidatoSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private CandidatoSkillRepository candidatoSkillRepository;

    @Autowired
    private CandidatoCertificadoRepository candidatoCertificadoRepository;

    @Override
    public List<CandidatoEntity> findAll() {
        return candidatoRepository.findAll();
    }

    @Override
    public List<CandidatoEntity> findBy(CandidatoEntity candidatoEntity) {
        CandidatoSpec candidatoSpec = new CandidatoSpec(candidatoEntity);
        List<CandidatoEntity> candidatoEntities = candidatoRepository.findAll(candidatoSpec);
        List<CandidatoEntity> candidatoEntitiesOut = skillSortWithCertified(candidatoEntity, candidatoEntities);
        return buildCandidatoData(candidatoEntitiesOut, candidatoEntities);
    }

    private List<CandidatoEntity> buildCandidatoData(List<CandidatoEntity> candidatoEntitiesOut, List<CandidatoEntity> candidatoEntities) {
        candidatoEntitiesOut.addAll(candidatoEntities);
        return candidatoEntitiesOut.stream().distinct().collect(Collectors.toList());
    }

    private List<CandidatoEntity> skillSortWithCertified(CandidatoEntity candidatoEntity, List<CandidatoEntity> candidatoEntities) {
        List<Long> skills = new ArrayList<>();
        if (candidatoEntity.getSkills() != null && !candidatoEntity.getSkills().isEmpty()) {
            skills = candidatoEntity.getSkills()
                    .stream()
                    .map(CandidatoSkillEntity::getSkill)
                    .map(SkillEntity::getId)
                    .collect(Collectors.toList());
        }
        List<Long> finalSkills = skills;

        List<CandidatoEntity> candidatoEntitiesOut = candidatoEntities
                .stream().distinct()
                .filter(candidate -> candidate.getCertificados()
                        .stream()
                        .filter(item2 -> finalSkills.contains(item2.getCertificado().getSkill().getId()))
                        .count() > 0

                ).collect(Collectors.toList());

        for (CandidatoEntity candidatoEntityFinal : candidatoEntitiesOut) {
            candidatoEntities.remove(candidatoEntityFinal);
        }

        return candidatoEntitiesOut;
    }

    @Override
    public CandidatoEntity findById(Long id) {
        return candidatoRepository.findById(id).orElse(null);
    }

    @Override
    public CandidatoEntity save(CandidatoEntity candidatoEntity) {
        return candidatoRepository.save(candidatoEntity);
    }

    @Override
    public CandidatoEntity create(CandidatoEntity candidatoEntity) {
        candidatoEntity.setId(null);
        return candidatoRepository.save(candidatoEntity);
    }

    @Override
    public void delete(Long id) {
        candidatoRepository.deleteById(id);
    }

    @Override
    public void createSkill(CandidatoSkillEntity candidatoSkillEntity) {
        CandidatoEntity candidatoEntity = findById(candidatoSkillEntity.getCandidato().getId());
        candidatoSkillEntity.setCandidato(candidatoEntity);
        candidatoSkillRepository.save(candidatoSkillEntity);
    }

    @Override
    public void createSkills(Long id, List<CandidatoSkillEntity> candidatoSkillEntities) {
        CandidatoEntity candidatoEntity = findById(id);
        deleteSkillsByCandidateId(candidatoEntity.getId());
        candidatoSkillEntities.forEach(candidatoSkill -> {
            candidatoSkill.setCandidato(candidatoEntity);
            candidatoSkillRepository.save(candidatoSkill);
        });
    }

    @Override
    public void deleteSkill(CandidatoSkillEntity candidatoSkillEntity) {
        candidatoSkillRepository.delete(candidatoSkillEntity);
    }

    @Override
    public void deleteSkillsByCandidateId(Long id) {
        candidatoSkillRepository.deleteSkillByCandidatoId(id);
    }

    @Override
    public List<CandidatoEntity> findCandidatosBySkillId(Long id) {
        return candidatoRepository.findCandidatosBySkillId(id);
    }

    @Override
    public void deleteBySkillId(Long id) {
        List<CandidatoEntity> candidatoEntities = findCandidatosBySkillId(id);
        candidatoRepository.deleteAll(candidatoEntities);
    }

    @Override
    public void createCertified(CandidatoCertificadoEntity candidatoCertificadoEntity) {
        CandidatoEntity candidatoEntity = findById(candidatoCertificadoEntity.getCandidato().getId());
        candidatoCertificadoEntity.setCandidato(candidatoEntity);
        candidatoCertificadoRepository.save(candidatoCertificadoEntity);
    }

    @Override
    public void createCertifieds(Long id, List<CandidatoCertificadoEntity> candidatoCertificadoEntities) {
        CandidatoEntity candidatoEntity = findById(id);
        deleteCertifiedssByCandidateId(candidatoEntity.getId());
        candidatoCertificadoEntities.forEach(candidatoCertificadoEntity -> {
            candidatoCertificadoEntity.setCandidato(candidatoEntity);
            candidatoCertificadoRepository.save(candidatoCertificadoEntity);
        });
    }

    @Override
    public void deleteCertified(CandidatoCertificadoEntity candidatoCertificadoEntity) {
        candidatoCertificadoRepository.delete(candidatoCertificadoEntity);
    }

    @Override
    public void deleteCertifiedssByCandidateId(Long id) {
        candidatoCertificadoRepository.deleteCertifiedsByCandidatoId(id);
    }
}
