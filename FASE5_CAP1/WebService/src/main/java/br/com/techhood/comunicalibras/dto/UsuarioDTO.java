package br.com.techhood.comunicalibras.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private TipoUsuarioDTO tipoUsuario;
    private PlanoDTO plano;
    private String avatar;
}
