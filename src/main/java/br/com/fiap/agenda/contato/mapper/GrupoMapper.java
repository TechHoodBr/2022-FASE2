package br.com.fiap.agenda.contato.mapper;


import br.com.fiap.agenda.contato.dto.GrupoDTO;
import br.com.fiap.agenda.contato.entity.GrupoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GrupoMapper {

    public GrupoDTO converterDTO(GrupoEntity grupoEntity) {
        if (grupoEntity != null) {
            GrupoDTO grupoDTO = new GrupoDTO();
            grupoDTO.setId(grupoEntity.getId());
            grupoDTO.setGrupo(grupoEntity.getGrupo());
            grupoDTO.setCriado(grupoEntity.getDataCriacao());
            grupoDTO.setAtivo(grupoEntity.getAtivo());
            return grupoDTO;
        }
        return null;
    }

    public List<GrupoDTO> converterDTOS(List<GrupoEntity> grupoEntities) {

        if (grupoEntities == null || grupoEntities.isEmpty()) {
            return null;
        }

        List<GrupoDTO> grupoDTOS = new ArrayList<>();

        for (GrupoEntity grupoEntity : grupoEntities) {
            grupoDTOS.add(converterDTO(grupoEntity));
        }
        return grupoDTOS;
    }
}
