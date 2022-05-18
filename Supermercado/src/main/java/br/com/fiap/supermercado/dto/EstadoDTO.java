package br.com.fiap.supermercado.dto;

import java.util.Calendar;

public class EstadoDTO {

    private Long id;
    private String estado;
    private Calendar criado;
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
