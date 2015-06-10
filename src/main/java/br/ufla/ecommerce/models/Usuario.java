package main.java.br.ufla.ecommerce.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 3065851993831168952L;
	
	@Id
	@GeneratedValue
	@Column(name="id_usuario")
	private int id;

	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="permissao")
	private int permissao;
	
	@OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_cpf")
	private Pessoa pessoa;
	
	@OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.EAGER)
	@Column(name="carrinho_id")
	private Carrinho carrinho;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
			name="compras",
			joinColumns={@JoinColumn(name="id_usuario")},
			inverseJoinColumns={@JoinColumn(name="usuario_id_usuario")})
	private List<Venda> compras;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
			name="comentarios",
			joinColumns={@JoinColumn(name="id_usuario")},
			inverseJoinColumns={@JoinColumn(name="id_usuario")})
	private List<Comentario> comentarios;
	
	public Usuario() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public List<Venda> getCompras() {
		return compras;
	}

	public void setCompras(List<Venda> compras) {
		this.compras = compras;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
