package br.com.fiap.supermercado.mapper;

import br.com.fiap.supermercado.dto.CidadeDTO;
import br.com.fiap.supermercado.entity.CidadeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CidadeMapper {

    public CidadeDTO converterDTO(CidadeEntity cidadeEntity) {
        if (cidadeEntity != null) {
            CidadeDTO cidadeDTO = new CidadeDTO();
            cidadeDTO.setId(cidadeEntity.getId());
            cidadeDTO.setCidade(cidadeEntity.getCidade());
            cidadeDTO.setCriado(cidadeEntity.getDataCriacao());
            cidadeDTO.setAtivo(cidadeEntity.getAtivo());
            return cidadeDTO;
        }
        return null;
    }

    public List<CidadeDTO> converterDTOS(List<CidadeEntity> cidadeEntities) {

        if (cidadeEntities == null || cidadeEntities.isEmpty()) {
            return null;
        }

        List<CidadeDTO> cidadeDTOS = new ArrayList<>();

        for (CidadeEntity cidadeEntity : cidadeEntities) {
            cidadeDTOS.add(converterDTO(cidadeEntity));
        }
        return cidadeDTOS;
    }
}
