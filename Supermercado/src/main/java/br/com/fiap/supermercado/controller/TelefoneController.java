package br.com.fiap.supermercado.controller;

import br.com.fiap.supermercado.dto.TelefoneDTO;
import br.com.fiap.supermercado.service.TelefoneService;
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
