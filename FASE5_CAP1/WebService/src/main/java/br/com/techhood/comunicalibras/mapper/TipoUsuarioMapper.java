package br.com.techhood.comunicalibras.mapper;

import br.com.techhood.comunicalibras.dto.TipoUsuarioDTO;
import br.com.techhood.comunicalibras.entity.TipoUsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TipoUsuarioMapper {

    public List<TipoUsuarioDTO> convert(List<TipoUsuarioEntity> tipoUsuarioEntities) {

        if (tipoUsuarioEntities == null || tipoUsuarioEntities.isEmpty()) {
            return null;
        }

        List<TipoUsuarioDTO> tipoUsuarioDTOS = new ArrayList<>();

        for (TipoUsuarioEntity tipoUsuarioEntity : tipoUsuarioEntities) {
            tipoUsuarioDTOS.add(convert(tipoUsuarioEntity));
        }
        return tipoUsuarioDTOS;
    }

    public TipoUsuarioDTO convert(TipoUsuarioEntity tipoUsuarioEntity) {

        if (tipoUsuarioEntity != null) {

            TipoUsuarioDTO tipoUsuario = new TipoUsuarioDTO();
            tipoUsuario.setId(tipoUsuarioEntity.getId());
            tipoUsuario.setNome(tipoUsuarioEntity.getNome());

            return tipoUsuario;
        }
        return null;
    }

    public TipoUsuarioEntity convert(TipoUsuarioDTO tipoUsuarioDTO) {

        if (tipoUsuarioDTO != null) {

            TipoUsuarioEntity tipoUsuario = new TipoUsuarioEntity();
            tipoUsuario.setId(tipoUsuarioDTO.getId());
            tipoUsuario.setNome(tipoUsuarioDTO.getNome());

            return tipoUsuario;
        }
        return null;
    }
}
