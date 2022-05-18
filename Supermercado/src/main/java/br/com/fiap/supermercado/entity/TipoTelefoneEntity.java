package br.com.fiap.supermercado.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "tb_spm_tipo_telefone")
@GenericGenerator(
		name = "tipoTelefoneSequenceGenerator",
		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters = {
				@org.hibernate.annotations.Parameter(name = "sequence_name", value = "seqSpmTipoTelefone"),
				@org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
				@org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
		}
)
public class TipoTelefoneEntity {

	@Id
	@Column(name = "id_tipo_telefone")
	@GeneratedValue(generator = "tipoTelefoneSequenceGenerator")
	private Long id;

	@Column(name = "nm_tipo_telefone", length = 100)
	private String tipoTelefone;

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

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
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
		return "TipoTelefoneEntity{" +
				"id=" + id +
				", tipoTelefone='" + tipoTelefone + '\'' +
				", dataCriacao=" + dataCriacao +
				", ativo=" + ativo +
				'}';
	}
}
