package br.com.fiap.supermercado.service.impl;

import br.com.fiap.supermercado.dto.TelefoneDTO;
import br.com.fiap.supermercado.entity.TelefoneEntity;
import br.com.fiap.supermercado.mapper.TelefoneMapper;
import br.com.fiap.supermercado.repository.TelefoneRepository;
import br.com.fiap.supermercado.service.TelefoneService;
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
