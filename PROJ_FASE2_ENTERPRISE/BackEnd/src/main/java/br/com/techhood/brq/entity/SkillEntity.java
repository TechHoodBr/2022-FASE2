package br.com.techhood.brq.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_brq_skill")
@GenericGenerator(
        name = "skillSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_tbl_brq_skill"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
)
public class SkillEntity extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id_skill", nullable = false, length = 19)
    @GeneratedValue(generator = "skillSequenceGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_skill", referencedColumnName = "id_categoria_skill", nullable = false, foreignKey = @ForeignKey(name = "fk_brq_skill_categoria_skill"))
    private CategoriaSkillEntity categoria;

    @Column(name = "nm_nome", nullable = false, length = 255)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaSkillEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaSkillEntity categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillEntity that = (SkillEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(categoria, that.categoria) &&
                Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoria, nome);
    }
}
