package br.com.fiap.agenda.contato.service.impl;

import br.com.fiap.agenda.contato.dto.PaisDTO;
import br.com.fiap.agenda.contato.entity.PaisEntity;
import br.com.fiap.agenda.contato.mapper.PaisMapper;
import br.com.fiap.agenda.contato.repository.PaisRepository;
import br.com.fiap.agenda.contato.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private PaisMapper paisMapper;

    @Override
    public List<PaisDTO> buscarTodos() {
        List<PaisEntity> paisEntities = paisRepository.findAll();
        return paisMapper.converterDTOS(paisEntities);
    }
}
