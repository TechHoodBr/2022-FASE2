package br.com.techhood.comunicalibras.dto;

import lombok.Data;

@Data
public class PlanoDTO {

    private Long id;
    private String nome;
    private String codigo;
    private Double valor;
}
