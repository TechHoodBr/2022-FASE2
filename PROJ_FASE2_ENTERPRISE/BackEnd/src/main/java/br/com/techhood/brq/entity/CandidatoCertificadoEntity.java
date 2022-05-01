package br.com.techhood.brq.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_brq_candidato_certificados")
@IdClass(CandidatoCertificadoId.class)
public class CandidatoCertificadoEntity implements Serializable {

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato", nullable = false, foreignKey = @ForeignKey(name = "fk_brq_candidato_certificados_candidato"))
    private CandidatoEntity candidato;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_certificado", referencedColumnName = "id_certificado", nullable = false, foreignKey = @ForeignKey(name = "fk_brq_candidato_certificados_certificado"))
    private CertificadoEntity certificado;

    public CandidatoEntity getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoEntity candidato) {
        this.candidato = candidato;
    }

    public CertificadoEntity getCertificado() {
        return certificado;
    }

    public void setCertificado(CertificadoEntity certificado) {
        this.certificado = certificado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidatoCertificadoEntity that = (CandidatoCertificadoEntity) o;
        return Objects.equals(candidato, that.candidato) &&
                Objects.equals(certificado, that.certificado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidato, certificado);
    }
}
