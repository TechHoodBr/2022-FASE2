package br.com.techhood.brq.entity;

import java.io.Serializable;
import java.util.Objects;

public class CandidatoCertificadoId implements Serializable {

    private Long candidato;
    private Long certificado;

    public CandidatoCertificadoId() {
    }

    public CandidatoCertificadoId(Long candidato, Long certificado) {
        this.candidato = candidato;
        this.certificado = certificado;
    }

    public Long getCandidato() {
        return candidato;
    }

    public void setCandidato(Long candidato) {
        this.candidato = candidato;
    }

    public Long getCertificado() {
        return certificado;
    }

    public void setCertificado(Long certificado) {
        this.certificado = certificado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidatoCertificadoId that = (CandidatoCertificadoId) o;
        return Objects.equals(candidato, that.candidato) &&
                Objects.equals(certificado, that.certificado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidato, certificado);
    }
}
