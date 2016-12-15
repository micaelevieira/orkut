package br.ufc.dao;

import java.util.List;

import br.ufc.model.Amizade;

public interface IAmizadeDAO {
	public void inserir(Amizade amizade);
	public List<Amizade> listarAmizadeId(Long id);
	public boolean existeAmizade(Amizade amizade);

}
