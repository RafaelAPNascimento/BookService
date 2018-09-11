package com.app;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.entidades.Livro;

@Startup
@Singleton
public class StartupService {	
 
	@Inject
	private BookService bookService;
	
    @PostConstruct
    public void init() {
    	 inserirRegistros();   	    	
    }
    
    @Transactional
    void inserirRegistros(){
    	
    	Livro livro = new Livro("livro 1", 500, 51.99);
    	bookService.salvar(livro);
    	livro = new Livro("livro 2", 1000, 170.32);
    	bookService.salvar(livro);
    	livro = new Livro("livro 3", 450, 12.0);
    	bookService.salvar(livro);
    	livro = new Livro("livro 4", 350, 21.5);
    	bookService.salvar(livro);
    	
    }
        

}
