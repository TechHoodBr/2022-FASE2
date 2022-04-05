package br.com.fiap.agenda.contato.dto;

import java.util.Calendar;

public class CidadeDTO {

    private Long id;
    private String cidade;
    private Calendar criado;
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
