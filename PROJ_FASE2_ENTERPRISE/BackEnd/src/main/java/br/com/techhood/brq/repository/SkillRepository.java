package br.com.techhood.brq.repository;

import br.com.techhood.brq.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

    List<SkillEntity> findByCategoria_Id(Long categoryId);
}
