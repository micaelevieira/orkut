package br.ufc.dao;

import java.util.List;

import br.ufc.model.Mensagem;

public interface IMensagemDAO {
		public void inserir(Mensagem mensagem);
		public void alterar(Mensagem mensagem);
		public Mensagem recuperar(Long id);
		public List<Mensagem> listar();
		public void apagar(Long id);


}
