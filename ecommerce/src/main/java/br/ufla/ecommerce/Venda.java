package br.ufla.ecommerce;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = 7196119063122977823L;
	
	@Id
	@Column(name="data")
	private Date data;
	
	@Column(name="valor")
	private float valor;
	
	@Column(name="status")
	private int status;
	
	@OneToOne(cascade=CascadeType.ALL, optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_carrinho") // TODO adicionar id_carrinho ao diagrama do banco de dados
	private Carrinho carrinho;
	
	@Id
	@Column(name="usuario_id_usuario")
	private Usuario usuario;
	
	public Venda() {
		
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
