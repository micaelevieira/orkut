package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Amizade;
@Repository
public class AmizadeDAOHibernate implements IAmizadeDAO {

	@PersistenceContext
	private EntityManager manager;
	@Override
	public void inserir(Amizade amizade) {
		if (!this.existeAmizade(amizade)){
			manager.persist(amizade);
		}
		
	}

	@Override
	public List<Amizade> listarAmizadeId(Long id) {
		String hql = "select a from AMIZADE as a "
				+"where a.usuarioFonte.id = :var_id";
		Query query = manager.createQuery(hql);
		query.setParameter("var_id", id);
		
		return query.getResultList();
	}

	@Override
	public boolean existeAmizade(Amizade amizade) {
		String hql = "select a from AMIZADE as a "
				+"where a.usuarioFonte.id = :fonte_id and "
				+"a.usuarioAlvo.id = :alvo_id";
		Query query = manager.createQuery(hql);
		query.setParameter("fonte_id", amizade.getUsuarioFonte().getUsuId());
		query.setParameter("alvo_id", amizade.getUsuarioAlvo().getUsuId());
		
		List<Amizade> amizades = query.getResultList();
		
		if (amizades!=null && amizades.size()>0) {
			return true;
		}
		return false;
		
	}
}
	