package br.ufc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="USUARIO")
public class Usuario {
	@Id
	@Column(name="USU_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long usuId;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="SOBRENOME")
	private String sobrenome;
	
	@Column(name="IDADE")
	private Integer idade;
	
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="SENHA")
	private String senha;
	
	//@Column(name="AVATAR")
	//private String avatar;// perguntar sobre ele
	
	
	//LISTA DE FOTOS - ONE-TO-MANY
	@OneToMany(mappedBy="usuario",targetEntity=Fotos.class,fetch=FetchType.EAGER)
	private Collection<Fotos> fotos;
	
	//LISTA DE FOTOS

	//LISTA DE COMUNIDADES, MANY-TO-MANY
	


	@ManyToMany(mappedBy="usuario",fetch=FetchType.EAGER)
	private List<Comunidade> comunidade;
	
	//LISTA DE COMUNIDADES
	
	//LISTA DE AMIGOS, ONE-TO-MANY
	
	@OneToMany(mappedBy="usuarioFonte")
	private List<Amizade> amizade = new ArrayList<Amizade>();
	
	//LISTA DE AMIGOS

	public Collection<Fotos> getFotos() {
		return fotos;
	}

	public void setFotos(Collection<Fotos> fotos) {
		this.fotos = fotos;
	}

	public List<Comunidade> getComunidade() {
		return comunidade;
	}

	public void setComunidade(List<Comunidade> comunidade) {
		this.comunidade = comunidade;
	}

	public List<Amizade> getAmizade() {
		return amizade;
	}

	public void setAmizade(List<Amizade> amizade) {
		this.amizade = amizade;
	}

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	

	//public String getAvatar() {
	//	return avatar;
	//}

	//public void setAvatar(String avatar) {
	//	this.avatar = avatar;
	//}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuId == null) ? 0 : usuId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuId == null) {
			if (other.usuId != null)
				return false;
		} else if (!usuId.equals(other.usuId))
			return false;
		return true;
	}
	
}
