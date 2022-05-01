package br.com.techhood.brq.repository;

import br.com.techhood.brq.entity.CategoriaSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaSkillRepository extends JpaRepository<CategoriaSkillEntity, Long> {

    @Query("SELECT c FROM CategoriaSkillEntity c INNER JOIN SkillEntity se ON c.id = se.categoria.id WHERE se.id = :id")
    List<CategoriaSkillEntity> findCategoriaBySkillId(@Param("id") Long id);

}
