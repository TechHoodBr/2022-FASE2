package br.com.techhood.comunicalibras.service.impl;

import br.com.techhood.comunicalibras.dto.UsuarioDTO;
import br.com.techhood.comunicalibras.entity.UsuarioEntity;
import br.com.techhood.comunicalibras.mapper.UsuarioMapper;
import br.com.techhood.comunicalibras.repository.UsuarioRepository;
import br.com.techhood.comunicalibras.service.UsuarioService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        usuarioEntity.setAvatar(avatarRequiredDefault(usuarioEntity));
        objeto = usuarioMapper.convert(usuarioEntity);
        return atualizarPorId(objeto.getId(), objeto);
    }

    @Override
    public UsuarioDTO atualizarPorId(Long id, UsuarioDTO objeto) {
        objeto.setId(id);
        UsuarioEntity usuarioEntity = usuarioRepository.save(usuarioMapper.convert(objeto));
        return usuarioMapper.convert(usuarioEntity);
    }

    @Override
    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioDTO> buscar(UsuarioDTO objeto) {

        UsuarioEntity usuarioEntity = usuarioMapper.convert(objeto);
        usuarioEntity.setAvatar(avatarRequiredDefault(usuarioEntity));
        Example<UsuarioEntity> exampleEntity = Example.of(usuarioEntity);
        return usuarioMapper.convert(usuarioRepository.findAll(exampleEntity));
    }

    private String avatarRequiredDefault(UsuarioEntity usuarioEntity) {
        Long id = usuarioEntity.getId();
        String avatar = usuarioEntity.getAvatar();

        if (avatar == null || Strings.isBlank(avatar)) {
            avatar = "https://i.pravatar.cc/300?img=" + id;
        } else if (avatar == "-1" )
            avatar = null;
        return avatar;
    }
}
