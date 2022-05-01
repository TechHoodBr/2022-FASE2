package br.com.techhood.brq.service;

import br.com.techhood.brq.entity.CategoriaSkillEntity;

import java.util.List;

public interface CategoriaService {

    List<CategoriaSkillEntity> findAll();

    CategoriaSkillEntity findById(Long id);

    CategoriaSkillEntity create(CategoriaSkillEntity categoriaSkillEntity);

    CategoriaSkillEntity save(CategoriaSkillEntity categoriaSkillEntity);

    void delete(Long id);

    List<CategoriaSkillEntity> findCategoriaBySkillId(Long id);

    void deleteBySkillId(Long id);
}
