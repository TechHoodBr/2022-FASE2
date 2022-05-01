package br.com.techhood.brq.controller;

import br.com.techhood.brq.entity.CandidatoCertificadoEntity;
import br.com.techhood.brq.entity.CandidatoEntity;
import br.com.techhood.brq.entity.CandidatoSkillEntity;
import br.com.techhood.brq.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CandidatoEntity> findAll() {
        return candidatoService.findAll();
    }

    @PostMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CandidatoEntity> findBy(@RequestBody CandidatoEntity candidatoEntity) {
        return candidatoService.findBy(candidatoEntity);
    }

    @PostMapping(value = "/criar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CandidatoEntity create(@RequestBody CandidatoEntity candidatoEntity) {
        return candidatoService.create(candidatoEntity);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CandidatoEntity findById(@PathVariable("id") Long id) {
        return candidatoService.findById(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CandidatoEntity update(@PathVariable("id") Long id, @RequestBody CandidatoEntity candidatoEntity) {
        candidatoEntity.setId(id);
        return candidatoService.save(candidatoEntity);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id) {
        candidatoService.delete(id);
    }

    @PostMapping(value = "/{id}/skill", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSkill(@PathVariable("id") Long id, @RequestBody List<CandidatoSkillEntity> candidatoSkillEntities) {
        candidatoService.createSkills(id, candidatoSkillEntities);
    }

    @DeleteMapping(value = "/{id}/skill", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSkill(@PathVariable("id") Long id) {
        candidatoService.deleteSkillsByCandidateId(id);
    }

    @PostMapping(value = "/{id}/certificado", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCertified(@PathVariable("id") Long id, @RequestBody List<CandidatoCertificadoEntity> candidatoCertificadoEntities) {
        candidatoService.createCertifieds(id, candidatoCertificadoEntities);
    }

    @DeleteMapping(value = "/{id}/certificado", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSkill(@PathVariable("id") Long id, @RequestBody CandidatoCertificadoEntity candidatoCertificadoEntity) {
        candidatoCertificadoEntity.setCandidato(new CandidatoEntity(id));
        candidatoService.deleteCertified(candidatoCertificadoEntity);
    }
}
