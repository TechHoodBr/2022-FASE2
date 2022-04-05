package br.com.fiap.agenda.contato.service.impl;

import br.com.fiap.agenda.contato.dto.ContatoDTO;
import br.com.fiap.agenda.contato.entity.ContatoEntity;
import br.com.fiap.agenda.contato.mapper.ContatoMapper;
import br.com.fiap.agenda.contato.repository.ContatoRepository;
import br.com.fiap.agenda.contato.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ContatoMapper contatoMapper;

    @Override
    public List<ContatoDTO> buscarTodos() {

        List<ContatoDTO> contatos = new ArrayList<>();
        List<ContatoEntity> contatosEntity = contatoRepository.findAll();

        if (contatosEntity != null && !contatosEntity.isEmpty()) {
            contatos = contatoMapper.converterDTOS(contatosEntity);
        }

        return contatos;
    }
}
