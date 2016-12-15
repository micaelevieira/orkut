package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Forum;

@Repository
public class ForumDAOHibernate implements IForumDAO{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Forum forum) {
		manager.persist(forum);
	}

	@Override
	public Forum recuperar(Long forId) {
		return manager.find(Forum.class, forId);
	}

	@Override
	public void alterar(Forum forum) {
		manager.merge(forum);
		
	}
	@Override
	public List<Forum> listar() {
		String hql = "select f from FORUM as f";
		return manager.createQuery(hql, Forum.class).getResultList();
	}

	@Override
	public void apagar(Long id) {
		Forum c = this.recuperar(id);
		manager.remove(c);
	}
}
