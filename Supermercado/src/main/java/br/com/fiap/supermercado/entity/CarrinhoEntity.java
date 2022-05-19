package br.com.fiap.supermercado.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
@Table(name = "tb_spm_carrinho")
@GenericGenerator(
        name = "carrinhoSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seqSpmCarrinho"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
)
public class CarrinhoEntity {

    @Id
    @Column(name = "id_carrinho")
    @GeneratedValue(generator = "carrinhoSequenceGenerator")
    private Long id;

    @Column(name = "cd_pedido", length = 100)
    private String pedido;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto", foreignKey = @ForeignKey(name = "fk_spm_carrinho_produto"))
    private ProdutoEntity produto;

    @Column(name = "nr_quantidade")
    private Integer quantidade;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_spm_carrinho_usuario"))
    private UsuarioEntity usuario;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_status", foreignKey = @ForeignKey(name = "fk_spm_carrinho_status"))
    private StatusEntity status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "CarrinhoEntity{" +
                "id=" + id +
                ", pedido='" + pedido + '\'' +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", usuario=" + usuario +
                ", status=" + status +
                '}';
    }
}
