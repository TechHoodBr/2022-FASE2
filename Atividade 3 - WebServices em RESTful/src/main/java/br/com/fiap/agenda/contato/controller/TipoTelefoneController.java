package br.com.fiap.agenda.contato.controller;

import br.com.fiap.agenda.contato.dto.TipoTelefoneDTO;
import br.com.fiap.agenda.contato.service.TipoTelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoTelefone")
public class TipoTelefoneController {

    @Autowired
    private TipoTelefoneService tipoTelefoneService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoTelefoneDTO> buscarTodos() {
        return tipoTelefoneService.buscarTodos();
    }
}
