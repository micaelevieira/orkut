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

@Entity(name="FORUM")
public class Forum {
	
	@Id
	@Column(name="FOR_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long forId;
	
	//@Column(name="COMU_ID",insertable=false, updatable=false,nullable=false)
	//private Long comuId;
	
	@Column(name="TITULO")
	private String titulo;
	
	//COMUNIDADE DONA DO FORUM, MANY-TO-ONE
	@ManyToOne(optional=false)
	@JoinColumn(name="COMU_ID",referencedColumnName="COMU_ID")
	private Comunidade comunidade;
	
	//COMUNIDADE DONA DO FORUM
	
	//LISTA DE MENSAGENS, ONE-TO-MANY

	@OneToMany(mappedBy="forum", targetEntity=Mensagem.class,fetch=FetchType.EAGER)
	private Collection<Mensagem> mensagem;
	
	//LISTA DE MENSAGENS

	public Long getForId() {
		return forId;
	}

	public void setForId(Long forId) {
		this.forId = forId;
	}

//	public Long getComuId() {
//		return comuId;
//	}
//
//	public void setComuId(Long comId) {
//		this.comuId = comId;
//	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public Collection<Mensagem> getMensagem() {
		return mensagem;
	}

	public void setMensagem(Collection<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}
	public void addMensagem(Mensagem mensagem) {
		this.mensagem.add(mensagem);
	}

}
