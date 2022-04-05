package br.com.fiap.agenda.contato.controller;

import br.com.fiap.agenda.contato.dto.PaisDTO;
import br.com.fiap.agenda.contato.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaisDTO> buscarTodos() {
        return paisService.buscarTodos();
    }
}
