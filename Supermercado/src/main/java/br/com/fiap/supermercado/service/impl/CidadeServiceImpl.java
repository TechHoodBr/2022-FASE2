package br.com.fiap.supermercado.service.impl;

import br.com.fiap.supermercado.dto.CidadeDTO;
import br.com.fiap.supermercado.entity.CidadeEntity;
import br.com.fiap.supermercado.mapper.CidadeMapper;
import br.com.fiap.supermercado.repository.CidadeRepository;
import br.com.fiap.supermercado.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeMapper cidadeMapper;

    @Override
    public List<CidadeDTO> buscarTodos() {
        List<CidadeEntity> cidadesEntity = cidadeRepository.findAll();
        return cidadeMapper.converterDTOS(cidadesEntity);
    }
}
