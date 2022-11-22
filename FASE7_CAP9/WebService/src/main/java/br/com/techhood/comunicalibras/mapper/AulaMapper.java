package br.com.techhood.comunicalibras.mapper;

import br.com.techhood.comunicalibras.dto.AulaDTO;
import br.com.techhood.comunicalibras.entity.AulaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AulaMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    public List<AulaDTO> convert(List<AulaEntity> aulaEntities) {

        if (aulaEntities == null || aulaEntities.isEmpty()) {
            return null;
        }

        List<AulaDTO> aulaDTOS = new ArrayList<>();

        for (AulaEntity aulaEntity : aulaEntities) {
            aulaDTOS.add(convert(aulaEntity));
        }
        return aulaDTOS;
    }

    public AulaDTO convert(AulaEntity aulaEntity) {

        if (aulaEntity != null) {

            AulaDTO aula = new AulaDTO();
            aula.setId(aulaEntity.getId());
            aula.setProfessor(usuarioMapper.convert(aulaEntity.getProfessor()));
            aula.setTitulo(aulaEntity.getTitulo());
            aula.setLive_inicio(aulaEntity.getLive_inicio());
            aula.setLive_fim(aulaEntity.getLive_fim());
            aula.setDescricao(aulaEntity.getDescricao());
            aula.setVideo(aulaEntity.getVideo());

            return aula;
        }
        return null;
    }

    public AulaEntity convert(AulaDTO aulaDTO) {

        if (aulaDTO != null) {

            AulaEntity aula = new AulaEntity();
            aula.setId(aulaDTO.getId());
            aula.setProfessor(usuarioMapper.convert(aulaDTO.getProfessor()));
            aula.setTitulo(aulaDTO.getTitulo());
            aula.setLive_inicio(aulaDTO.getLive_inicio());
            aula.setLive_fim(aulaDTO.getLive_fim());
            aula.setDescricao(aulaDTO.getDescricao());
            aula.setVideo(aulaDTO.getVideo());

            return aula;
        }
        return null;
    }
}
