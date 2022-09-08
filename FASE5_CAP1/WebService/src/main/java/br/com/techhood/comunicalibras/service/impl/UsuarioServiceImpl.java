package br.com.techhood.comunicalibras.service.impl;

import br.com.techhood.comunicalibras.dto.UsuarioDTO;
import br.com.techhood.comunicalibras.entity.UsuarioEntity;
import br.com.techhood.comunicalibras.mapper.UsuarioMapper;
import br.com.techhood.comunicalibras.repository.UsuarioRepository;
import br.com.techhood.comunicalibras.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> buscarTodos() {
        List<UsuarioEntity> usuarioEntities = usuarioRepository.findAll();
        return usuarioMapper.convert(usuarioEntities);
    }

    @Override
    public UsuarioDTO buscarPorId(Long id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).orElse(null);
        return usuarioMapper.convert(usuarioEntity);
    }

    @Override
    public UsuarioDTO inserir(UsuarioDTO objeto) {
        objeto.setId(null);
        UsuarioEntity usuarioEntity = usuarioMapper.convert(objeto);
        usuarioEntity = usuarioRepository.save(usuarioEntity);
        return usuarioMapper.convert(usuarioEntity);
    }

    @Override
    public UsuarioDTO atualizar(Long id, UsuarioDTO objeto) {
        objeto.setId(id);
        UsuarioEntity usuarioEntity = usuarioRepository.save(usuarioMapper.convert(objeto));
        return usuarioMapper.convert(usuarioEntity);
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
