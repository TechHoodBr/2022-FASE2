package br.com.fiap.agenda.contato.controller;

import br.com.fiap.agenda.contato.dto.ContatoDTO;
import br.com.fiap.agenda.contato.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContatoDTO> buscarTodos() {
        return contatoService.buscarTodos();
    }
}
