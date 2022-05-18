package br.com.fiap.supermercado.mapper;

import br.com.fiap.supermercado.dto.TipoTelefoneDTO;
import br.com.fiap.supermercado.entity.TipoTelefoneEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TipoTelefoneMapper {

    public TipoTelefoneDTO converterDTO(TipoTelefoneEntity TipoTelefoneEntity) {
        if (TipoTelefoneEntity != null) {
            TipoTelefoneDTO tipoTelefoneDTO = new TipoTelefoneDTO();
            tipoTelefoneDTO.setId(TipoTelefoneEntity.getId());
            tipoTelefoneDTO.setTipoTelefone(TipoTelefoneEntity.getTipoTelefone());
            tipoTelefoneDTO.setCriado(TipoTelefoneEntity.getDataCriacao());
            tipoTelefoneDTO.setAtivo(TipoTelefoneEntity.getAtivo());
            return tipoTelefoneDTO;
        }
        return null;
    }

    public List<TipoTelefoneDTO> converterDTOS(List<TipoTelefoneEntity> tipoTelefoneEntities) {

        if (tipoTelefoneEntities == null || tipoTelefoneEntities.isEmpty()) {
            return null;
        }

        List<TipoTelefoneDTO> tipoTelefoneDTOS = new ArrayList<>();

        for (TipoTelefoneEntity TipoTelefoneEntity : tipoTelefoneEntities) {
            tipoTelefoneDTOS.add(converterDTO(TipoTelefoneEntity));
        }
        return tipoTelefoneDTOS;
    }
}
