package br.ufc.dao;

import java.util.List;

import br.ufc.model.Usuario;

public interface IUsuarioDAO {
	public void inserir(Usuario usuario);
	public void alterar(Usuario usuario);
	public Usuario recuperar(Long id);
	public Usuario recuperar(String login);
	public List<Usuario> listar();
	public void apagar(Long id);

}
