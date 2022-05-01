package br.com.techhood.brq.controller;

import br.com.techhood.brq.entity.SkillEntity;
import br.com.techhood.brq.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SkillEntity> findAll() {
        return skillService.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SkillEntity create(@RequestBody SkillEntity skillEntity) {
        return skillService.create(skillEntity);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SkillEntity findById(@PathVariable("id") Long id) {
        return skillService.findById(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SkillEntity update(@PathVariable("id") Long id, @RequestBody SkillEntity skillEntity) {
        skillEntity.setId(id);
        return skillService.save(skillEntity);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id) {
        skillService.delete(id);
    }

    @GetMapping(value = "/{categoriaId}/categoria", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SkillEntity> findByCategory(@PathVariable("categoriaId") Long categoryId) {
        return skillService.findByCategory(categoryId);
    }
}
