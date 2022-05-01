package br.com.techhood.brq.entity;

import java.io.Serializable;
import java.util.Objects;

public class CandidatoSkillId implements Serializable {

    private Long candidato;
    private Long skill;

    public CandidatoSkillId() {
    }

    public CandidatoSkillId(Long candidato, Long skill) {
        this.candidato = candidato;
        this.skill = skill;
    }

    public Long getCandidato() {
        return candidato;
    }

    public void setCandidato(Long candidato) {
        this.candidato = candidato;
    }

    public Long getSkill() {
        return skill;
    }

    public void setSkill(Long skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidatoSkillId that = (CandidatoSkillId) o;
        return Objects.equals(candidato, that.candidato) &&
                Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidato, skill);
    }
}
