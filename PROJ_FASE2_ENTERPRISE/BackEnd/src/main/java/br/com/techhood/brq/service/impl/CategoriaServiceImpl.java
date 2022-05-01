package br.com.techhood.brq.service.impl;

import br.com.techhood.brq.entity.CategoriaSkillEntity;
import br.com.techhood.brq.entity.SkillEntity;
import br.com.techhood.brq.repository.CategoriaSkillRepository;
import br.com.techhood.brq.service.CategoriaService;
import br.com.techhood.brq.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaSkillRepository categoriaSkillRepository;

    @Autowired
    private SkillService skillService;

    @Override
    public List<CategoriaSkillEntity> findAll() {
        return categoriaSkillRepository.findAll();
    }

    @Override
    public CategoriaSkillEntity findById(Long id) {
        return categoriaSkillRepository.findById(id).orElse(null);
    }

    @Override
    public CategoriaSkillEntity create(CategoriaSkillEntity categoriaSkillEntity) {
        categoriaSkillEntity.setId(null);
        return categoriaSkillRepository.save(categoriaSkillEntity);
    }

    @Override
    public CategoriaSkillEntity save(CategoriaSkillEntity categoriaSkillEntity) {
        return categoriaSkillRepository.save(categoriaSkillEntity);
    }

    @Override
    public void delete(Long id) {
        List<SkillEntity> skillEntities = skillService.findByCategory(id);
        skillEntities.forEach(skillEntity -> {
            skillService.delete(skillEntity.getId());
        });
        categoriaSkillRepository.deleteById(id);
    }

    @Override
    public List<CategoriaSkillEntity> findCategoriaBySkillId(Long id) {
        return categoriaSkillRepository.findCategoriaBySkillId(id);
    }

    @Override
    public void deleteBySkillId(Long id) {
        List<CategoriaSkillEntity> categoriaSkillEntities = findCategoriaBySkillId(id);
        categoriaSkillRepository.deleteAll(categoriaSkillEntities);
    }
}
