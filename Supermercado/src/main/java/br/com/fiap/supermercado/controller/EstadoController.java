package br.com.fiap.supermercado.controller;

import br.com.fiap.supermercado.dto.EstadoDTO;
import br.com.fiap.supermercado.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EstadoDTO> buscarTodos() {
        return estadoService.buscarTodos();
    }
}
