package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="MENSAGEM")
public class Mensagem {
	
	@Id
	@Column(name="MEN_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long menId;
	
	@Column(name="FOR_ID",insertable=false, updatable=false,nullable=false)
	private Long forId;
	
	@Column(name="TEXTO")
	private String texto;
	
	//FORUM DONO DA MENSAGEM, MANY-TO-ONE
	
	@ManyToOne(optional=false)
	@JoinColumn(name="FOR_ID",referencedColumnName="FOR_ID")
	private Forum forum;
	
	//FORUM DONO DA MENSAGEM
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getMenId() {
		return menId;
	}

	public void setMenId(Long menId) {
		this.menId = menId;
	}

	public Long getForId() {
		return forId;
	}

	public void setForId(Long forId) {
		this.forId = forId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}
	

}
