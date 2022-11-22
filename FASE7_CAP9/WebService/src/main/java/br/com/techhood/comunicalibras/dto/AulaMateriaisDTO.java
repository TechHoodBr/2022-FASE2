package br.com.techhood.comunicalibras.dto;

import br.com.techhood.comunicalibras.entity.AulaEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AulaMateriaisDTO {

    private Long id;
    private AulaDTO aula;
    private String nome_arquivo;
    private String arquivo;
    private LocalDateTime upload;
    private Integer baixado;
}
