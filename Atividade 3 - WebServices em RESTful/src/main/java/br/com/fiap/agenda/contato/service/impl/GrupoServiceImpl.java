package br.com.fiap.agenda.contato.service.impl;

import br.com.fiap.agenda.contato.dto.GrupoDTO;
import br.com.fiap.agenda.contato.entity.GrupoEntity;
import br.com.fiap.agenda.contato.mapper.GrupoMapper;
import br.com.fiap.agenda.contato.repository.GrupoRepository;
import br.com.fiap.agenda.contato.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private GrupoMapper grupoMapper;

    @Override
    public List<GrupoDTO> buscarTodos() {
        List<GrupoEntity> grupoEntities = grupoRepository.findAll();
        return grupoMapper.converterDTOS(grupoEntities);
    }
}
