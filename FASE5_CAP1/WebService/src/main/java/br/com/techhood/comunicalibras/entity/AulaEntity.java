package br.com.techhood.comunicalibras.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_cml_aula")
@GenericGenerator(
        name = "aulaSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_cml_aula"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
)
public class AulaEntity {

    @Id
    @Column(name = "id_aula")
    @GeneratedValue(generator = "aulaSequenceGenerator")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_cml_aula_usuario"), nullable = false)
    private UsuarioEntity professor;

    @Column(name = "ds_titulo", length = 100)
    private String titulo;

    @Column(name = "dt_inicio_live")
    private LocalDateTime live_inicio;

    @Column(name = "dt_fim_live")
    private LocalDateTime live_fim;

    @Column(name = "ds_descricao", length = 1000)
    private String descricao;

    @Column(name = "ds_url_video", length = 255)
    private String video;
}
