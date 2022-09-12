package br.com.techhood.comunicalibras.entity;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_cml_usuario")
@GenericGenerator(
        name = "usuarioSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_cml_usuario"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
)
public class UsuarioEntity {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(generator = "usuarioSequenceGenerator")
    private Long id;

    @Column(name = "nm_nome", length = 100)
    private String nome;

    @Column(name = "ds_login", length = 100)
    private String login;

    @Column(name = "ds_senha", length = 100)
    private String senha;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_tipo_usuario", foreignKey = @ForeignKey(name = "fk_cml_usuario_tipo_usuario"), nullable = false)
    private TipoUsuarioEntity tipoUsuario;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_plano", foreignKey = @ForeignKey(name = "fk_cml_usuario_plano"), nullable = false)
    private PlanoEntity plano;

    @Column(name = "url_avatar", length = 1000)
    private String avatar;

    public String getAvatar() {
        return avatarRequiredDefault(avatar);
    }

    private String avatarRequiredDefault(String avatar) {
        if (avatar == null || Strings.isBlank(avatar)) {
            avatar = "https://i.pravatar.cc/300";
        }
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatarRequiredDefault(avatar);;
    }
}
