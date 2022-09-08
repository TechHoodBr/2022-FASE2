package br.com.techhood.comunicalibras.mapper;

import br.com.techhood.comunicalibras.dto.PlanoDTO;
import br.com.techhood.comunicalibras.entity.PlanoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanoMapper {

    public List<PlanoDTO> convert(List<PlanoEntity> planoEntities) {

        if (planoEntities == null || planoEntities.isEmpty()) {
            return null;
        }

        List<PlanoDTO> planoDTOS = new ArrayList<>();

        for (PlanoEntity planoEntity : planoEntities) {
            planoDTOS.add(convert(planoEntity));
        }
        return planoDTOS;
    }

    public PlanoDTO convert(PlanoEntity planoEntity) {

        if (planoEntity != null) {

            PlanoDTO planoDTO = new PlanoDTO();
            planoDTO.setId(planoEntity.getId());
            planoDTO.setNome(planoEntity.getNome());
            planoDTO.setCodigo(planoEntity.getCodigo());
            planoDTO.setValor(planoEntity.getValor());

            return planoDTO;
        }
        return null;
    }

    public PlanoEntity convert(PlanoDTO planoDTO) {

        if (planoDTO != null) {

            PlanoEntity plano = new PlanoEntity();
            plano.setId(planoDTO.getId());
            plano.setNome(planoDTO.getNome());
            plano.setCodigo(planoDTO.getCodigo());
            plano.setValor(planoDTO.getValor());

            return plano;
        }
        return null;
    }
}
