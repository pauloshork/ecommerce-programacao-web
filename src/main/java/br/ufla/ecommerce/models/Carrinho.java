package main.java.br.ufla.ecommerce.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="carrinho")
public class Carrinho implements Serializable {
	private static final long serialVersionUID = -8690755011845171970L;
	
	@Id
	@GeneratedValue
	@Column(name="id_carrinho")
	private int id;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="carrinho_has_produto", 
			joinColumns={@JoinColumn(name="id_carrinho")}, 
			inverseJoinColumns={@JoinColumn(name="id_produto")})
	private List<Produto> produtos;
	
	@OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.EAGER, mappedBy="venda")
	private Venda venda;
	
	@OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.EAGER, mappedBy="usuario")
	private Usuario usuario;
	
	public Carrinho() {
		
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
