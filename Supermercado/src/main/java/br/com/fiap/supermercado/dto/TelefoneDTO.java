package br.com.fiap.supermercado.dto;

import java.util.Calendar;

public class TelefoneDTO {

    private Long id;
    private Long usuarioId;
    private TipoTelefoneDTO tipoTelefone;
    private String telefone;
    private Calendar criado;
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public TipoTelefoneDTO getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefoneDTO tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Calendar getCriado() {
        return criado;
    }

    public void setCriado(Calendar criado) {
        this.criado = criado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
