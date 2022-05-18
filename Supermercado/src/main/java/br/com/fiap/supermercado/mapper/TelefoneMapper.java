package br.com.fiap.supermercado.mapper;

import br.com.fiap.supermercado.dto.TelefoneDTO;
import br.com.fiap.supermercado.entity.TelefoneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelefoneMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private TipoTelefoneMapper tipoTelefoneMapper;

    public TelefoneDTO converterDTO(TelefoneEntity telefoneEntity) {
        if (telefoneEntity != null) {
            TelefoneDTO telefoneDTO = new TelefoneDTO();
            telefoneDTO.setId(telefoneEntity.getId());
            telefoneDTO.setUsuarioId(telefoneEntity.getUsuario().getId());
            telefoneDTO.setTipoTelefone(tipoTelefoneMapper.converterDTO(telefoneEntity.getTipoTelefone()));
            telefoneDTO.setTelefone(telefoneEntity.getTelefone());
            telefoneDTO.setCriado(telefoneEntity.getDataCriacao());
            telefoneDTO.setAtivo(telefoneEntity.getAtivo());
            return telefoneDTO;
        }
        return null;
    }

    public List<TelefoneDTO> converterDTOS(List<TelefoneEntity> telefoneEntities) {

        if (telefoneEntities == null || telefoneEntities.isEmpty()) {
            return null;
        }

        List<TelefoneDTO> telefoneDTOS = new ArrayList<>();

        for (TelefoneEntity telefoneEntity : telefoneEntities) {
            telefoneDTOS.add(converterDTO(telefoneEntity));
        }
        return telefoneDTOS;
    }
}
