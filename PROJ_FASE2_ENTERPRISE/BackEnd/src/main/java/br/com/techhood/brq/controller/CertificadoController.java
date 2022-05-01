package br.com.techhood.brq.controller;

import br.com.techhood.brq.entity.CertificadoEntity;
import br.com.techhood.brq.service.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/certificado")
public class CertificadoController {

    @Autowired
    private CertificadoService certificadoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CertificadoEntity> findAll() {
        return certificadoService.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CertificadoEntity create(@RequestBody CertificadoEntity certificadoEntity) {
        return certificadoService.create(certificadoEntity);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CertificadoEntity findById(@PathVariable("id") Long id) {
        return certificadoService.findById(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CertificadoEntity update(@PathVariable("id") Long id, @RequestBody CertificadoEntity certificadoEntity) {
        certificadoEntity.setId(id);
        return certificadoService.save(certificadoEntity);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id) {
        certificadoService.delete(id);
    }
}
