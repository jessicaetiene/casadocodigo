package br.com.casadocodigo.loja.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Produto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager manager;

	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email)
				.getResultList();
		
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuario " + email + " não foi encontrado");
		}
		
		return usuarios.get(0);
	}

	public Usuario emailCadastrado(String email){
		try{
			return manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (NoResultException e){
			return null;
		}
	}

	public void gravar(Usuario usuario) {
		manager.persist(usuario);
	}

	public List<Usuario> listar() {
		return manager.createQuery("select distinct(u) from Usuario u", Usuario.class)
				.getResultList();
	}

    public void atualizarRoles(Usuario usuarioAlterado) {
		manager.merge(usuarioAlterado);
    }
}