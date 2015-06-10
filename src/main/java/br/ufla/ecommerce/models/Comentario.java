package main.java.br.ufla.ecommerce.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="comentario")
public class Comentario implements Serializable {

	private static final long serialVersionUID = 5789417444951699219L;
	
	@Id
	@GeneratedValue
	@Column(name="id_comentario")
	private int id;
	
	@Column(name="date")
	private Date data;
	
	@Column(name="comentario")
	private String comentario;
	
	@Id
	@ManyToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_produto")
	private Produto produto;
	
	@Id
	@OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	public Comentario() {
		
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
