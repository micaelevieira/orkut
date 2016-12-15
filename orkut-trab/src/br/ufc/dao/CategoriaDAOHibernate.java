package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Categoria;
import br.ufc.model.Comunidade;

@Repository
public class CategoriaDAOHibernate implements ICategoriaDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Categoria> listar() {
		String hql = "select c from CATEGORIA as c";
		return manager.createQuery(hql, Categoria.class).getResultList();
		
	}

}
