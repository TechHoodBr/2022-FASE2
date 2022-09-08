package br.com.techhood.comunicalibras.mapper;

import br.com.techhood.comunicalibras.dto.UsuarioDTO;
import br.com.techhood.comunicalibras.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {

    @Autowired
    private TipoUsuarioMapper tipoUsuarioMapper;

    @Autowired
    private PlanoMapper planoMapper;

    public List<UsuarioDTO> convert(List<UsuarioEntity> usuarioEntities) {

        if (usuarioEntities == null || usuarioEntities.isEmpty()) {
            return null;
        }

        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for (UsuarioEntity usuarioEntity : usuarioEntities) {
            usuarioDTOS.add(convert(usuarioEntity));
        }
        return usuarioDTOS;
    }

    public UsuarioDTO convert(UsuarioEntity usuarioEntity) {

        if (usuarioEntity != null) {

            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setId(usuarioEntity.getId());
            usuario.setNome(usuarioEntity.getNome());
            usuario.setLogin(usuarioEntity.getLogin());
            usuario.setSenha(usuarioEntity.getSenha());
            usuario.setTipoUsuario(tipoUsuarioMapper.convert(usuarioEntity.getTipoUsuario()));
            usuario.setPlano(planoMapper.convert(usuarioEntity.getPlano()));

            return usuario;
        }
        return null;
    }

    public UsuarioEntity convert(UsuarioDTO usuarioDTO) {

        if (usuarioDTO != null) {

            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId(usuarioDTO.getId());
            usuario.setNome(usuarioDTO.getNome());
            usuario.setLogin(usuarioDTO.getLogin());
            usuario.setSenha(usuarioDTO.getSenha());
            usuario.setTipoUsuario(tipoUsuarioMapper.convert(usuarioDTO.getTipoUsuario()));
            usuario.setPlano(planoMapper.convert(usuarioDTO.getPlano()));

            return usuario;
        }
        return null;
    }
}
