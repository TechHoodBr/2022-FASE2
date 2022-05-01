package br.com.techhood.brq.service;

import br.com.techhood.brq.entity.CertificadoEntity;

import java.util.List;

public interface CertificadoService {

    List<CertificadoEntity> findAll();

    CertificadoEntity findById(Long id);

    CertificadoEntity create(CertificadoEntity certificadoEntity);

    CertificadoEntity save(CertificadoEntity certificadoEntity);

    void delete(Long id);

    List<CertificadoEntity> findBySkillId(Long id);

    void deleteBySkillId(Long id);
}
