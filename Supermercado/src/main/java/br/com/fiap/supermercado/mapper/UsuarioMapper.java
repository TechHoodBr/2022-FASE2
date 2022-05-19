package br.com.fiap.supermercado.mapper;

import br.com.fiap.supermercado.dto.UsuarioDTO;
import br.com.fiap.supermercado.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private TelefoneMapper telefoneMapper;

    @Autowired
    private GrupoMapper grupoMapper;

    public UsuarioDTO converterDTO(UsuarioEntity usuarioEntity) {
        if (usuarioEntity != null) {
            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setId(usuarioEntity.getId());
            usuario.setNome(usuarioEntity.getNome());
            usuario.setSobrenome(usuarioEntity.getSobrenome());
            usuario.setApelido(usuarioEntity.getApelido());
            usuario.setFoto(usuarioEntity.getFoto());
            usuario.setGrupo(grupoMapper.converterDTO(usuarioEntity.getGrupo()));
            usuario.setCriado(usuarioEntity.getDataCriacao());
            usuario.setAtivo(usuarioEntity.getAtivo());
            return usuario;
        }
        return null;
    }

    public List<UsuarioDTO> converterDTOS(List<UsuarioEntity> usuarioEntities) {

        if (usuarioEntities == null || usuarioEntities.isEmpty()) {
            return null;
        }

        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for (UsuarioEntity usuarioEntity : usuarioEntities) {
            usuarioDTOS.add(converterDTO(usuarioEntity));
        }
        return usuarioDTOS;
    }
}
