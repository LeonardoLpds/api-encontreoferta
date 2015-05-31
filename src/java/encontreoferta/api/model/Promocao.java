package encontreoferta.api.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "promocao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocao.findAll", query = "SELECT p FROM Promocao p"),
    @NamedQuery(name = "Promocao.findById", query = "SELECT p FROM Promocao p WHERE p.id = :id"),
    @NamedQuery(name = "Promocao.findByNome", query = "SELECT p FROM Promocao p WHERE p.nome = :nome"),
    @NamedQuery(name = "Promocao.findByDescricao", query = "SELECT p FROM Promocao p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Promocao.findByDataFinal", query = "SELECT p FROM Promocao p WHERE p.dataFinal = :dataFinal"),
    @NamedQuery(name = "Promocao.findByImagem", query = "SELECT p FROM Promocao p WHERE p.imagem = :imagem"),
    @NamedQuery(name = "Promocao.findByQuantidade", query = "SELECT p FROM Promocao p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Promocao.findByOferta", query = "SELECT p FROM Promocao p WHERE p.oferta = :oferta"),
    @NamedQuery(name = "Promocao.findByCategoria", query = "SELECT p FROM Promocao p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "Promocao.findByNivel", query = "SELECT p FROM Promocao p WHERE p.nivel = :nivel"),
    @NamedQuery(name = "Promocao.findByVendedor", query = "SELECT p FROM Promocao p WHERE p.vendedor = :vendedor")
})
public class Promocao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_final")
    @Temporal(TemporalType.DATE)
    private Date dataFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "imagem")
    private String imagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "oferta")
    private String oferta;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nivel nivel;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vendedor vendedor;

    public Promocao() {
    }

    public Promocao(Integer id) {
        this.id = id;
    }

    public Promocao(Integer id, String nome, String descricao, Date dataFinal, String imagem, int quantidade, String oferta) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataFinal = dataFinal;
        this.imagem = imagem;
        this.quantidade = quantidade;
        this.oferta = oferta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocao)) {
            return false;
        }
        Promocao other = (Promocao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encontreoferta.api.model.Promocao[ id=" + id + " ]";
    }
    
}
