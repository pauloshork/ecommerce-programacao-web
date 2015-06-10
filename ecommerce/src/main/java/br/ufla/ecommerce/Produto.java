package br.ufla.ecommerce;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 7150659000519540258L;
	
	@Id
	@GeneratedValue
	@Column(name="id_produto")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="preco") // TODO adicionar preço ao diagrama do banco de dados
	private float preco;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="quantidade_estoque")
	private int quantidadeEstoque;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="comentario")
	private List<Comentario> comentarios;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="carrinho")
	private List<Carrinho> carrinhos;
	
	public Produto() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(List<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}
}
