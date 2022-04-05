package br.com.fiap.agenda.contato.controller;

import br.com.fiap.agenda.contato.dto.TelefoneDTO;
import br.com.fiap.agenda.contato.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TelefoneDTO> buscarTodos() {
        return telefoneService.buscarTodos();
    }
}
