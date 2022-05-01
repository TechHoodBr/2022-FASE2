package br.com.techhood.brq.service.impl;

import br.com.techhood.brq.entity.SkillEntity;
import br.com.techhood.brq.repository.SkillRepository;
import br.com.techhood.brq.service.CandidatoService;
import br.com.techhood.brq.service.CategoriaService;
import br.com.techhood.brq.service.CertificadoService;
import br.com.techhood.brq.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private CertificadoService certificadoService;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public List<SkillEntity> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public SkillEntity findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public SkillEntity create(SkillEntity skillEntity) {
        skillEntity.setId(null);
        return skillRepository.save(skillEntity);
    }

    @Override
    public SkillEntity save(SkillEntity skillEntity) {
        return skillRepository.save(skillEntity);
    }

    @Override
    public void delete(Long id) {
        candidatoService.deleteBySkillId(id);
        certificadoService.deleteBySkillId(id);
        if (findById(id) != null)
            skillRepository.deleteById(id);
    }

    @Override
    public List<SkillEntity> findByCategory(Long categoryId) {
        return skillRepository.findByCategoria_Id(categoryId);
    }
}
