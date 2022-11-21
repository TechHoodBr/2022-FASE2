package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.dto.UsuarioDTO;
import br.com.techhood.comunicalibras.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends RestCrudController<UsuarioDTO> {

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        super.crudService = usuarioService;
    }
}
