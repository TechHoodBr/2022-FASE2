package br.com.fiap.agenda.contato.controller;

import br.com.fiap.agenda.contato.dto.GrupoDTO;
import br.com.fiap.agenda.contato.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GrupoDTO> buscarTodos() {
        return grupoService.buscarTodos();
    }
}
