package br.com.fiap.louja.crud.controller.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.louja.crud.model.Filme;

public class FilmeDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadora");
	EntityManager manager = factory.createEntityManager();
	
	public void inserir(Filme filme) {
		manager.getTransaction().begin();
		manager.persist(filme);
		manager.getTransaction().commit();
	}
	
	public List<Filme> listarTodos(){
		String jpql = "SELECT p FROM Filme p";
		TypedQuery<Filme> query = manager.createQuery(jpql , Filme.class);
		return query.getResultList();
	}
	
	public void apagar(Filme filme) {
		manager.getTransaction().begin();
		manager.remove(manager.merge(filme));
		manager.getTransaction().commit();
	}
	
	public void atualizar(Filme filme) {
		manager.getTransaction().begin();
		manager.merge(filme);
		manager.getTransaction().commit();
	}

}
