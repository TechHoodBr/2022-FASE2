package br.com.fiap.supermercado.mapper;

import br.com.fiap.supermercado.dto.EstadoDTO;
import br.com.fiap.supermercado.entity.EstadoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstadoMapper {

    public EstadoDTO converterDTO(EstadoEntity estadoEntity) {
        if (estadoEntity != null) {
            EstadoDTO estadoDTO = new EstadoDTO();
            estadoDTO.setId(estadoEntity.getId());
            estadoDTO.setEstado(estadoEntity.getEstado());
            estadoDTO.setCriado(estadoEntity.getDataCriacao());
            estadoDTO.setAtivo(estadoEntity.getAtivo());
            return estadoDTO;
        }
        return null;
    }

    public List<EstadoDTO> converterDTOS(List<EstadoEntity> estadoEntities) {

        if (estadoEntities == null || estadoEntities.isEmpty()) {
            return null;
        }

        List<EstadoDTO> estadoDTOS = new ArrayList<>();

        for (EstadoEntity estadoEntity : estadoEntities) {
            estadoDTOS.add(converterDTO(estadoEntity));
        }
        return estadoDTOS;
    }
}
