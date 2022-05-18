package br.com.fiap.supermercado.service.impl;

import br.com.fiap.supermercado.dto.EnderecoDTO;
import br.com.fiap.supermercado.entity.EnderecoEntity;
import br.com.fiap.supermercado.mapper.EnderecoMapper;
import br.com.fiap.supermercado.repository.EnderecoRepository;
import br.com.fiap.supermercado.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Override
    public List<EnderecoDTO> buscarTodos() {
        List<EnderecoEntity> enderecoEntities = enderecoRepository.findAll();
        return enderecoMapper.converterDTOS(enderecoEntities);
    }
}
