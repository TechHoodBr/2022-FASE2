package br.com.techhood.comunicalibras.service;

import java.util.List;

public interface CrudService<T> {

    List<T> buscarTodos();
    T buscarPorId(Long id);
    T inserir(T objeto);
    T atualizar(Long id, T objeto);
    void deletar(Long id);
}
