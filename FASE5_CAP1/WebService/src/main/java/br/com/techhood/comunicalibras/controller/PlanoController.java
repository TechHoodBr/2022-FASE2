package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.dto.PlanoDTO;
import br.com.techhood.comunicalibras.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/plano")
public class PlanoController extends RestCrudController<PlanoDTO> {

    @Autowired
    public PlanoController(PlanoService planoService) {
        super.crudService = planoService;
    }
}
