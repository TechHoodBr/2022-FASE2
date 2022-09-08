package br.com.techhood.comunicalibras.controller;

import br.com.techhood.comunicalibras.service.CrudService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RestCrudController<T> implements CrudService<T> {

    protected CrudService<T> crudService;

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<T> buscarTodos() {
        return crudService.buscarTodos();
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public T buscarPorId(@PathVariable("id") Long id) {
        return crudService.buscarPorId(id);
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public T inserir(@RequestBody T objeto) {
        return crudService.inserir(objeto);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public T atualizar(@PathVariable("id") Long id, @RequestBody T objeto) {
        return crudService.atualizar(id, objeto);
    }

    @Override
    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deletar(@PathVariable("id") Long id) {
        crudService.deletar(id);
    }
}
