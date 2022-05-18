package br.com.fiap.supermercado.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "tb_spm_telefone")
@GenericGenerator(
		name = "telefoneSequenceGenerator",
		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters = {
				@org.hibernate.annotations.Parameter(name = "sequence_name", value = "seqSpmTelefone"),
				@org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
				@org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
		}
)
public class TelefoneEntity {

	@Id
	@Column(name = "id_telefone")
	@GeneratedValue(generator = "telefoneSequenceGenerator")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_spm_telefone_usuario"))
	private UsuarioEntity usuario;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tipo_telefone", foreignKey = @ForeignKey(name = "fk_spm_telefone_tipo_telefone"))
	private TipoTelefoneEntity tipoTelefone;

	@Column(name = "nr_telefone", length = 100)
	private String telefone;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;

	@Column(name = "fl_ativo")
	private Boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public TipoTelefoneEntity getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefoneEntity tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	@Override
	public String toString() {
		return "TelefoneEntity{" +
				"id=" + id +
				", tipoTelefone=" + tipoTelefone +
				", telefone='" + telefone + '\'' +
				", dataCriacao=" + dataCriacao +
				", ativo=" + ativo +
				'}';
	}
}
