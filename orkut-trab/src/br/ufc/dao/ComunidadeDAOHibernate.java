package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Amizade;
import br.ufc.model.Comunidade;
import br.ufc.model.Usuario;

@Repository
public class ComunidadeDAOHibernate implements IComunidadeDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void inserir(Comunidade comunidade) {
		manager.persist(comunidade);
		
	}

	@Override
	public List<Comunidade> listar() {
		
		String hql = "select c from COMUNIDADE as c";
		return manager.createQuery(hql, Comunidade.class).getResultList();
	}

	@Override
	public void apagar(Long id) {
		manager.remove(id);
	}

	@Override
	public Comunidade recuperar(Long id) {
		
		return manager.find(Comunidade.class, id);
	}

	@Override
	public void atualizar(Comunidade comunidade) {
		manager.merge(comunidade);
		
	}
	
	@Override
	public void participar(Long idComunidade, Usuario u) {
		Comunidade c = recuperar(idComunidade);
		List<Usuario> usuarios = c.getUsuario();
		
		usuarios.add(u);
		c.setUsuario(usuarios);
		manager.merge(c);

	}



	
	
}
