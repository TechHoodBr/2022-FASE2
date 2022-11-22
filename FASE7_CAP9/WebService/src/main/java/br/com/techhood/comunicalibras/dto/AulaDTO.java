package br.com.techhood.comunicalibras.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AulaDTO {

    private Long id;
    private UsuarioDTO professor;
    private String titulo;
    private LocalDateTime live_inicio;
    private LocalDateTime live_fim;
    private String descricao;
    private String video;
}
