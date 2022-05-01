package br.com.techhood.brq.controller;

import br.com.techhood.brq.entity.CategoriaSkillEntity;
import br.com.techhood.brq.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoriaSkillEntity> findAll() {
        return categoriaService.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CategoriaSkillEntity create(@RequestBody CategoriaSkillEntity categoriaSkillEntity) {
        return categoriaService.create(categoriaSkillEntity);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoriaSkillEntity findById(@PathVariable("id") Long id) {
        return categoriaService.findById(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CategoriaSkillEntity update(@PathVariable("id") Long id, @RequestBody CategoriaSkillEntity categoriaSkillEntity) {
        categoriaSkillEntity.setId(id);
        return categoriaService.save(categoriaSkillEntity);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id) {
        categoriaService.delete(id);
    }
}
