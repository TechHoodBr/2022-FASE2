package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.dto.TipoUsuarioDTO;
import br.com.techhood.comunicalibras.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController extends RestCrudController<TipoUsuarioDTO> {

    @Autowired
    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        super.crudService = tipoUsuarioService;
    }
}
