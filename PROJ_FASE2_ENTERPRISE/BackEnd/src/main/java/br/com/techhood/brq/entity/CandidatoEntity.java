package br.com.techhood.brq.entity;

import br.com.techhood.brq.enums.GeneroEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_brq_candidato")
@GenericGenerator(
        name = "candidatoSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_tbl_brq_candidato"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
)
public class CandidatoEntity extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id_candidato", nullable = false, length = 19)
    @GeneratedValue(generator = "candidatoSequenceGenerator")
    private Long id;

    @Column(name = "nm_nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "nr_cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "ds_email", nullable = false, length = 255)
    private String email;

    @Column(name = "nr_telefone", nullable = false, length = 10)
    private Long telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "st_genero", nullable = false, length = 1)
    private GeneroEnum genero;

    @Column(name = "dt_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CandidatoSkillEntity> skills;

    @OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CandidatoCertificadoEntity> certificados;

    public CandidatoEntity() {
    }

    public CandidatoEntity(Long id) {
        this.id = id;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public List<CandidatoSkillEntity> getSkills() {
        return skills;
    }

    public void setSkills(List<CandidatoSkillEntity> skills) {
        this.skills = skills;
    }

    public List<CandidatoCertificadoEntity> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<CandidatoCertificadoEntity> certificados) {
        this.certificados = certificados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidatoEntity that = (CandidatoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telefone, that.telefone) &&
                genero == that.genero &&
                Objects.equals(nascimento, that.nascimento) &&
                Objects.equals(skills, that.skills) &&
                Objects.equals(certificados, that.certificados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, email, telefone, genero, nascimento, skills, certificados);
    }
}
