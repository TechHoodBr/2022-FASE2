package br.com.fiap.agenda.contato.service.impl;

import br.com.fiap.agenda.contato.dto.EnderecoDTO;
import br.com.fiap.agenda.contato.entity.EnderecoEntity;
import br.com.fiap.agenda.contato.mapper.EnderecoMapper;
import br.com.fiap.agenda.contato.repository.EnderecoRepository;
import br.com.fiap.agenda.contato.service.EnderecoService;
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
