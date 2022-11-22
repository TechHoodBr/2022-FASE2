package br.com.techhood.comunicalibras.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_cml_aula_materiais")
@GenericGenerator(
        name = "aulaMateriaisSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_cml_aula_materiais"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
)
public class AulaMateriaisEntity {

    @Id
    @Column(name = "id_aula_materiais")
    @GeneratedValue(generator = "aulaMateriaisSequenceGenerator")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_aula", foreignKey = @ForeignKey(name = "fk_cml_aula_materiais_aula"))
    private AulaEntity aula;

    @Column(name = "nm_nome_arquivo", length = 100)
    private String nome_arquivo;

    @Column(name = "ds_url_arquivo", length = 255)
    private String arquivo;

    @Column(name = "dt_upload")
    private LocalDateTime upload;

    @Column(name = "nu_baixado")
    private Integer baixado;
}
