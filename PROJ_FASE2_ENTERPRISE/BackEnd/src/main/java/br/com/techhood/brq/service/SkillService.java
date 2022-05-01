package br.com.techhood.brq.service;

import br.com.techhood.brq.entity.SkillEntity;

import java.util.List;

public interface SkillService {

    List<SkillEntity> findAll();

    SkillEntity findById(Long id);

    SkillEntity create(SkillEntity skillEntity);

    SkillEntity save(SkillEntity skillEntity);

    void delete(Long id);

    List<SkillEntity> findByCategory(Long category);
}
