package br.com.fiap.agenda.contato.service.impl;

import br.com.fiap.agenda.contato.dto.TipoTelefoneDTO;
import br.com.fiap.agenda.contato.entity.TipoTelefoneEntity;
import br.com.fiap.agenda.contato.mapper.TipoTelefoneMapper;
import br.com.fiap.agenda.contato.repository.TipoTelefoneRepository;
import br.com.fiap.agenda.contato.service.TipoTelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTelefoneServiceImpl implements TipoTelefoneService {

    @Autowired
    private TipoTelefoneRepository tipoTelefoneRepository;

    @Autowired
    private TipoTelefoneMapper tipoTelefoneMapper;

    @Override
    public List<TipoTelefoneDTO> buscarTodos() {
        List<TipoTelefoneEntity> tipoTelefoneEntities = tipoTelefoneRepository.findAll();
        return tipoTelefoneMapper.converterDTOS(tipoTelefoneEntities);
    }
}
