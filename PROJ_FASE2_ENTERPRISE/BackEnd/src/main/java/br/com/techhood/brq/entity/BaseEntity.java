package br.com.techhood.brq.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity {

    @CreationTimestamp
    @Column(name = "dh_criado", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime criado;

    @UpdateTimestamp
    @Column(name = "dh_atualizado", nullable = true)
    private LocalDateTime atualizado;

    @Column(name = "st_inativo", columnDefinition = "number(1,0) default 0")
    private Boolean inativo;

    public LocalDateTime getCriado() {
        return criado;
    }

    public void setCriado(LocalDateTime criado) {
        this.criado = criado;
    }

    public LocalDateTime getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(LocalDateTime atualizado) {
        this.atualizado = atualizado;
    }

    public Boolean isInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(criado, that.criado) &&
                Objects.equals(atualizado, that.atualizado) &&
                Objects.equals(inativo, that.inativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criado, atualizado, inativo);
    }
}
