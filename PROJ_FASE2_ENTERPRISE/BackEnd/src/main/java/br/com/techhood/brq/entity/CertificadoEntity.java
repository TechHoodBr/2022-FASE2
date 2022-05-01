package br.com.techhood.brq.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_brq_certificado")
@GenericGenerator(
        name = "certificadoSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_tbl_brq_certificado"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
)
public class CertificadoEntity extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id_certificado", nullable = false, length = 19)
    @GeneratedValue(generator = "certificadoSequenceGenerator")
    private Long id;

    @Column(name = "nm_nome", nullable = false, length = 255)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_skill", referencedColumnName = "id_skill", nullable = false, foreignKey = @ForeignKey(name = "fk_brq_certificado_skill"))
    private SkillEntity skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        CertificadoEntity that = (CertificadoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, skill);
    }
}
