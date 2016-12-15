package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="AMIZADE")
public class Amizade {
	
	@Id
	@Column(name="AMI_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long amiId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuarioFonte;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="AMIGO_ID")
	private Usuario usuarioAlvo;

	public Long getAmiId() {
		return amiId;
	}

	public void setAmiId(Long amiId) {
		this.amiId = amiId;
	}

	public Usuario getUsuarioFonte() {
		return usuarioFonte;
	}

	public void setUsuarioFonte(Usuario usuarioFonte) {
		this.usuarioFonte = usuarioFonte;
	}

	public Usuario getUsuarioAlvo() {
		return usuarioAlvo;
	}

	public void setUsuarioAlvo(Usuario usuarioAlvo) {
		this.usuarioAlvo = usuarioAlvo;
	}
	
	

}
