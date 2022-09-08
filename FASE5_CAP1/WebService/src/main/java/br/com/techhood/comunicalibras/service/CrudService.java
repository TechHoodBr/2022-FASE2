package br.com.techhood.comunicalibras.service;

import java.util.List;

public interface CrudService<T> {

    List<T> buscarTodos();
    T buscarPorId(Long id);
    T inserir(T objeto);
    T atualizarPorId(Long id, T objeto);
    void deletarPorId(Long id);
}
