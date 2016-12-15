package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="COMENTARIOS")
public class Comentarios {

	
	@Id
	@Column(name="COM_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long comId;
	
	@Column(name="FOT_ID",insertable=false,updatable=false,nullable=false)
	private Long fotId;
	
	@Column(name="TEXTO")
	private String texto;
	
	//FOTO DONA DO COMETARIO, MANY-TO-ONE

	@ManyToOne(optional=false)
	@JoinColumn(name="FOT_ID",referencedColumnName="FOT_ID")
	private Fotos fotos;
	
	//FOTO DONA DO COMETARIO

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public Long getFotId() {
		return fotId;
	}

	public void setFotId(Long fotId) {
		this.fotId = fotId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Fotos getFotos() {
		return fotos;
	}

	public void setFotos(Fotos fotos) {
		this.fotos = fotos;
	}
}
