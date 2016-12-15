package br.ufc.dao;

import java.util.List;

import br.ufc.model.Forum;

public interface IForumDAO {
	void inserir(Forum forum);
	Forum recuperar(Long forId);
	public void alterar(Forum forum);
	public List<Forum> listar();
	public void apagar(Long id);
	
}
