package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.dto.AulaDTO;
import br.com.techhood.comunicalibras.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aula")
public class AulaController extends RestCrudController<AulaDTO> {

    @Autowired
    public AulaController(AulaService aulaService) {
        super.crudService = aulaService;
    }
}
