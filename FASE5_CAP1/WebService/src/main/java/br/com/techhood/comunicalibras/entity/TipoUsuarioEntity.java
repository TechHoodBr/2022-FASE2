package br.com.techhood.comunicalibras.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_cml_tipo_usuario")
@GenericGenerator(
        name = "tipoUsuarioSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_cml_tipo_usuario"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
)
public class TipoUsuarioEntity {

    @Id
    @Column(name = "id_tipo_usuario")
    @GeneratedValue(generator = "tipoUsuarioSequenceGenerator")
    private Long id;

    @Column(name = "nm_nome", length = 100)
    private String nome;
}
