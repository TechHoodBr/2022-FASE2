package br.com.techhood.brq.service.impl;

import br.com.techhood.brq.entity.CertificadoEntity;
import br.com.techhood.brq.repository.CandidatoCertificadoRepository;
import br.com.techhood.brq.repository.CertificadoSkillRepository;
import br.com.techhood.brq.service.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificadoServiceImpl implements CertificadoService {

    @Autowired
    private CertificadoSkillRepository certificadoSkillRepository;

    @Autowired
    private CandidatoCertificadoRepository candidatoCertificadoRepository;

    @Override
    public List<CertificadoEntity> findAll() {
        return certificadoSkillRepository.findAll();
    }

    @Override
    public CertificadoEntity findById(Long id) {
        return certificadoSkillRepository.findById(id).orElse(null);
    }

    @Override
    public CertificadoEntity create(CertificadoEntity certificadoEntity) {
        certificadoEntity.setId(null);
        return certificadoSkillRepository.save(certificadoEntity);
    }

    @Override
    public CertificadoEntity save(CertificadoEntity certificadoEntity) {
        return certificadoSkillRepository.save(certificadoEntity);
    }

    @Override
    public void delete(Long id) {
        candidatoCertificadoRepository.deleteByCertifiedId(id);
        certificadoSkillRepository.deleteById(id);
    }

    @Override
    public List<CertificadoEntity> findBySkillId(Long id) {
        return certificadoSkillRepository.findBySkillId(id);
    }

    @Override
    public void deleteBySkillId(Long id) {
        List<CertificadoEntity> certificadoEntities = findBySkillId(id);
        certificadoSkillRepository.deleteAll(certificadoEntities);
    }
}
