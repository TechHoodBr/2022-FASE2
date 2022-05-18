package br.com.fiap.supermercado.service.impl;

import br.com.fiap.supermercado.dto.UsuarioDTO;
import br.com.fiap.supermercado.entity.UsuarioEntity;
import br.com.fiap.supermercado.mapper.UsuarioMapper;
import br.com.fiap.supermercado.repository.UsuarioRepository;
import br.com.fiap.supermercado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> buscarTodos() {

        List<UsuarioDTO> usuarios = new ArrayList<>();
        List<UsuarioEntity> usuariosEntity = usuarioRepository.findAll();

        if (usuariosEntity != null && !usuariosEntity.isEmpty()) {
            usuarios = usuarioMapper.converterDTOS(usuariosEntity);
        }

        return usuarios;
    }
}
