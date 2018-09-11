package com.app;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entidades.Livro;

@Model
public class BookService {

	@PersistenceContext(name = "BookDS")
	private EntityManager em;
	
	public 	void salvar(Livro book) {
		
		em.persist(book);
	}
}
