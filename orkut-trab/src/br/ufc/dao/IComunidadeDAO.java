package br.ufc.dao;

import java.util.List;

import br.ufc.model.Comunidade;
import br.ufc.model.Usuario;

public interface IComunidadeDAO {
	
	public void inserir(Comunidade comunidade);
	public void atualizar(Comunidade comunidade);
	public List<Comunidade> listar();
	public Comunidade recuperar(Long id);
	public void apagar(Long id);
	void participar(Long idComunidade, Usuario u);
	//public List<Comunidade> listarComunidade();

}
