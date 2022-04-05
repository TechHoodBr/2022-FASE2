package br.com.fiap.agenda.contato.service.impl;

import br.com.fiap.agenda.contato.dto.TelefoneDTO;
import br.com.fiap.agenda.contato.entity.TelefoneEntity;
import br.com.fiap.agenda.contato.mapper.TelefoneMapper;
import br.com.fiap.agenda.contato.repository.TelefoneRepository;
import br.com.fiap.agenda.contato.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneServiceImpl implements TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private TelefoneMapper telefoneMapper;

    @Override
    public List<TelefoneDTO> buscarTodos() {
        List<TelefoneEntity> telefoneEntities = telefoneRepository.findAll();
        return telefoneMapper.converterDTOS(telefoneEntities);
    }
}
