package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="CATEGORIA")
public class Categoria {
	
	@Id
	@Column(name="CAT_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long catId;
	
	@Column(name="NOME", nullable=false)
	private String nome;
	
	//LISTA DE COMUNIDADES, ONE-TO-MANY
	
	@OneToMany(mappedBy="categoria", targetEntity=Comunidade.class,fetch=FetchType.EAGER)
	private Collection<Comunidade> comunidade;
	
	//LISTA DE COMUNIDADES

	public Collection<Comunidade> getComunidade() {
		return comunidade;
	}

	public void setComunidade(Collection<Comunidade> comunidade) {
		this.comunidade = comunidade;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
