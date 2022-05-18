package br.com.fiap.supermercado.service.impl;

import br.com.fiap.supermercado.dto.GrupoDTO;
import br.com.fiap.supermercado.entity.GrupoEntity;
import br.com.fiap.supermercado.mapper.GrupoMapper;
import br.com.fiap.supermercado.repository.GrupoRepository;
import br.com.fiap.supermercado.service.GrupoService;
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
