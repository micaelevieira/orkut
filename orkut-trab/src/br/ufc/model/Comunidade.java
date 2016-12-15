package br.ufc.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="COMUNIDADE")
public class Comunidade {

	@Id
	@Column(name="COMU_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long comuId;

	//@Column(name="CAT_ID",insertable=false, updatable=false,nullable=false)
	//private Long catId;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="IMAGEM")
	private String imagem;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	//LISTA DE FÓRUNS DA COMUNIDADE, ONE-TO-MANY
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@OneToMany(mappedBy="comunidade", cascade=CascadeType.MERGE, targetEntity=Forum.class,fetch=FetchType.EAGER)
	private Collection<Forum> forum;
	
	//LISTA DE FÓRUNS DA COMUNIDADE
	
	//CATEGORIA DONA DA COMUNIDADE, MANY-TO-ONE

	@ManyToOne(optional=true)
	@JoinColumn(name="CAT_ID",referencedColumnName="CAT_ID")
	private Categoria categoria;
	
	//CATEGORIA DONA DA COMUNIDADE
	
	//MANY-TO-MANY, GERANDO TABELA USUARIO_COMUNIDADE
	
	@ManyToMany
	@JoinTable(name="USUARIO_COMUNIDADE",
				joinColumns=@JoinColumn(name="COMU_ID",referencedColumnName="COMU_ID"),
				inverseJoinColumns=@JoinColumn(name="USU_ID",referencedColumnName="USU_ID")
	)//joinColums e inverse, dúvida se fiz certo ou trocado
	private List<Usuario> usuario;
	
	//MANY-TO-MANY

	public Long getComuId() {
		return comuId;
	}

	public void setComuId(Long comId) {
		this.comuId = comId;
	}

//	public Long getCatId() {
//		return catId;
//	}

//	public void setCatId(Long catId) {
//		this.catId = catId;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Collection<Forum> getForum() {
		return forum;
	}

	public void setForum(Collection<Forum> forum) {
		this.forum = forum;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
}
