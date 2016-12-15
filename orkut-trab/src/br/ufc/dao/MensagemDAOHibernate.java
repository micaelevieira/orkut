package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Mensagem;

@Repository
public class MensagemDAOHibernate implements IMensagemDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Mensagem mensagem) {
		manager.persist(mensagem);
		
	}

	@Override
	public void alterar(Mensagem mensagem) {
		manager.merge(mensagem);
		
	}

	@Override
	public Mensagem recuperar(Long id) {
		return manager.find(Mensagem.class, id);
	}


	@Override
	public List<Mensagem> listar() {
		String hql = "select f from MENSAGEM as m";
		return manager.createQuery(hql, Mensagem.class).getResultList();
	}

	@Override
	public void apagar(Long id) {
		Mensagem c = this.recuperar(id);
		manager.remove(c);
	}
}

