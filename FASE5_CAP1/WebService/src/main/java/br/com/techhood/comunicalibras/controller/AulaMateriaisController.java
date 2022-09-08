package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.dto.AulaMateriaisDTO;
import br.com.techhood.comunicalibras.service.AulaMateriaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aulaMateriais")
public class AulaMateriaisController extends RestCrudController<AulaMateriaisDTO> {

    @Autowired
    public AulaMateriaisController(AulaMateriaisService aulaMateriaisService) {
        super.crudService = aulaMateriaisService;
    }
}
