package br.com.casadocodigo.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Role;

import java.util.List;

@Repository
@Transactional
public class RoleDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Role role) {
		manager.persist(role);
	}

	public List<Role> listar() {
		return manager.createQuery("select distinct(r) from Role r", Role.class)
				.getResultList();
	}
}
