package br.com.fiap.supermercado.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "tb_spm_usuario")
@GenericGenerator(
		name = "usuarioSequenceGenerator",
		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters = {
				@org.hibernate.annotations.Parameter(name = "sequence_name", value = "seqSpmUsuario"),
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

	@Column(name = "nm_sobrenome", length = 100)
	private String sobrenome;

	@Column(name = "nm_apelido", length = 14)
	private String apelido;

	@Column(name = "ds_email", length = 100)
	private String email;

	@Column(name = "ds_login", length = 100)
	private String login;

	@Column(name = "ds_senha", length = 100)
	private String senha;

	@Column(name = "bin_foto")
	private String foto;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_grupo", foreignKey = @ForeignKey(name = "fk_spm_usuario_grupo"))
	private GrupoEntity grupo;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_ultimo_acesso")
	private Calendar ultimoAcesso;

	@Column(name = "fl_ativo")
	private Boolean ativo;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_status", foreignKey = @ForeignKey(name = "fk_spm_usuario_status"))
	private StatusEntity status;

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public GrupoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoEntity grupo) {
		this.grupo = grupo;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Calendar ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UsuarioEntity{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", sobrenome='" + sobrenome + '\'' +
				", apelido='" + apelido + '\'' +
				", email='" + email + '\'' +
				", login='" + login + '\'' +
				", senha='" + senha + '\'' +
				", foto='" + foto + '\'' +
				", grupo=" + grupo +
				", dataCriacao=" + dataCriacao +
				", ultimoAcesso=" + ultimoAcesso +
				", ativo=" + ativo +
				", status=" + status +
				'}';
	}
}
