package br.com.fiap.agenda.contato.mapper;

import br.com.fiap.agenda.contato.dto.PaisDTO;
import br.com.fiap.agenda.contato.entity.PaisEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaisMapper {
    
    public PaisDTO converterDTO(PaisEntity paisEntity) {
        if (paisEntity != null) {
            PaisDTO paisDTO = new PaisDTO();
            paisDTO.setId(paisEntity.getId());
            paisDTO.setPais(paisEntity.getPais());
            paisDTO.setCriado(paisEntity.getDataCriacao());
            paisDTO.setAtivo(paisEntity.getAtivo());
            return paisDTO;
        }
        return null;
    }

    public List<PaisDTO> converterDTOS(List<PaisEntity> paisEntities) {

        if (paisEntities == null || paisEntities.isEmpty()) {
            return null;
        }

        List<PaisDTO> paisDTOS = new ArrayList<>();

        for (PaisEntity paisEntity : paisEntities) {
            paisDTOS.add(converterDTO(paisEntity));
        }
        return paisDTOS;
    }
}
