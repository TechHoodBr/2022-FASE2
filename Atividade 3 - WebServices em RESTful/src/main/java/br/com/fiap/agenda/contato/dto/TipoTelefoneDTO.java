package br.com.fiap.agenda.contato.dto;

import java.util.Calendar;

public class TipoTelefoneDTO {

    private Long id;
    private String tipoTelefone;
    private Calendar criado;
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
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
