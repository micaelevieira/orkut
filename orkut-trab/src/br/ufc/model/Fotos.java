package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="FOTOS")
public class Fotos {

	@Id
	@Column(name="FOT_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long fotId;
	
	@Column(name="USU_ID",insertable=false,updatable=false,nullable=false)
	private Long usuId;
	
	@Column(name="IMAGEM")
	private String imagem;
	
	//FOTOS DO USUARIO, MANY-TO-ONE - Usuario dono das fotos

	@ManyToOne(optional=false)
	@JoinColumn(name="USU_ID",referencedColumnName="USU_ID")
	private Usuario usuario;
	
	//FOTOS DO USUARIO, MANY-TO-ONE
	
	//LISTA DE COMENTÁRIOS, ONE-TO-MANY, COMENTÁRIOS NA FOTO
	
	@OneToMany(mappedBy="fotos", targetEntity=Comentarios.class,fetch=FetchType.EAGER)
	private Collection<Comentarios> comentarios;
	
	//LISTA DE COMENTÁRIOS

	public Long getFotId() {
		return fotId;
	}

	public void setFotId(Long fotId) {
		this.fotId = fotId;
	}

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Collection<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}
}
