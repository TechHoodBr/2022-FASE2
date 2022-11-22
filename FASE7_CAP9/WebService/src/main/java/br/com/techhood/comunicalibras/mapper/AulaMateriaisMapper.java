package br.com.techhood.comunicalibras.mapper;

import br.com.techhood.comunicalibras.dto.AulaMateriaisDTO;
import br.com.techhood.comunicalibras.entity.AulaMateriaisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AulaMateriaisMapper {

    @Autowired
    private AulaMapper aulaMapper;

    public List<AulaMateriaisDTO> convert(List<AulaMateriaisEntity> aulaMateriaisEntities) {

        if (aulaMateriaisEntities == null || aulaMateriaisEntities.isEmpty()) {
            return null;
        }

        List<AulaMateriaisDTO> aulaMateriaisDTOS = new ArrayList<>();

        for (AulaMateriaisEntity aulaMateriaisEntity : aulaMateriaisEntities) {
            aulaMateriaisDTOS.add(convert(aulaMateriaisEntity));
        }
        return aulaMateriaisDTOS;
    }

    public AulaMateriaisDTO convert(AulaMateriaisEntity aulaMateriaisEntity) {

        if (aulaMateriaisEntity != null) {

            AulaMateriaisDTO aulaMateriais = new AulaMateriaisDTO();
            aulaMateriais.setId(aulaMateriaisEntity.getId());
            aulaMateriais.setAula(aulaMapper.convert(aulaMateriaisEntity.getAula()));
            aulaMateriais.setNome_arquivo(aulaMateriaisEntity.getNome_arquivo());
            aulaMateriais.setArquivo(aulaMateriaisEntity.getArquivo());
            aulaMateriais.setUpload(aulaMateriaisEntity.getUpload());
            aulaMateriais.setBaixado(aulaMateriaisEntity.getBaixado());

            return aulaMateriais;
        }
        return null;
    }

    public AulaMateriaisEntity convert(AulaMateriaisDTO aulaMateriaisDTO) {

        if (aulaMateriaisDTO != null) {

            AulaMateriaisEntity aulaMateriais = new AulaMateriaisEntity();
            aulaMateriais.setId(aulaMateriaisDTO.getId());
            aulaMateriais.setAula(aulaMapper.convert(aulaMateriaisDTO.getAula()));
            aulaMateriais.setNome_arquivo(aulaMateriaisDTO.getNome_arquivo());
            aulaMateriais.setArquivo(aulaMateriaisDTO.getArquivo());
            aulaMateriais.setUpload(aulaMateriaisDTO.getUpload());
            aulaMateriais.setBaixado(aulaMateriaisDTO.getBaixado());

            return aulaMateriais;
        }
        return null;
    }
}
