package br.com.fiap.supermercado.service.impl;

import br.com.fiap.supermercado.dto.EstadoDTO;
import br.com.fiap.supermercado.entity.EstadoEntity;
import br.com.fiap.supermercado.mapper.EstadoMapper;
import br.com.fiap.supermercado.repository.EstadoRepository;
import br.com.fiap.supermercado.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoMapper estadoMapper;

    @Override
    public List<EstadoDTO> buscarTodos() {
        List<EstadoEntity> estadoEntities = estadoRepository.findAll();
        return estadoMapper.converterDTOS(estadoEntities);
    }
}
