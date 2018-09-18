package com.app;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entidades.Livro;

@Stateless
@Path("livros")
public class LivrosREST {

	@PersistenceContext(unitName = "livrosDataSourcePU")
	private EntityManager em;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Livro> findAll() {
		
		List<Livro> livros = null;
		try {
			TypedQuery<Livro> query = em.createNamedQuery("Livro.buscarTodos", Livro.class);
			livros = query.getResultList();
		}
		catch (NoResultException e) {
		}
		return livros;
	}
}
