package br.com.techhood.brq.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_brq_candidato_skills")
@IdClass(CandidatoSkillId.class)
public class CandidatoSkillEntity implements Serializable {

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidato", referencedColumnName = "id_candidato", nullable = false, foreignKey = @ForeignKey(name = "fk_brq_candidato_skills_candidato"))
    private CandidatoEntity candidato;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_skill", referencedColumnName = "id_skill", nullable = false, foreignKey = @ForeignKey(name = "fk_brq_candidato_skills_skill"))
    private SkillEntity skill;

    public CandidatoEntity getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoEntity candidato) {
        this.candidato = candidato;
    }

    public SkillEntity getSkill() {
        return skill;
    }

    public void setSkill(SkillEntity skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidatoSkillEntity that = (CandidatoSkillEntity) o;
        return Objects.equals(candidato, that.candidato) &&
                Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidato, skill);
    }
}
