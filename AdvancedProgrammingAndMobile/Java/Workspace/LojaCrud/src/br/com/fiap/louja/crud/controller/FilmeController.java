package br.com.fiap.louja.crud.controller;

import java.util.List;

import br.com.fiap.louja.crud.controller.DAO.FilmeDAO;
import br.com.fiap.louja.crud.model.Filme;
import br.com.fiap.louja.crud.view.Janela;

public class FilmeController {

	FilmeDAO filmeDAO;
	Janela view;
	
	public FilmeController(Janela view) {
		filmeDAO = new FilmeDAO();
		this.view = view;
	}
	

	public void mockarDadosIniciais() {
		Filme f = new Filme();
		f.setTitulo("Wanda Vision");
		f.setAssistido(true);
		f.setGenero("Comedia");
		f.setOndeAssistir("Prime Video");
		f.setAvaliacao(5);
	
		filmeDAO.inserir(f);
		
	}

	public List<Filme> listarTodos() {
		return filmeDAO.listarTodos();
	}

	public void salvarFilme(String titulo, String sinopse, String genero, String ondeAssistiu, boolean assistido, int avaliacao) {
		Filme f = new Filme();
		f.setTitulo(titulo);
		f.setSinopse(sinopse);
		f.setAssistido(assistido);
		f.setGenero(genero);
		f.setOndeAssistir(ondeAssistiu);
		f.setAvaliacao(avaliacao);
		
		filmeDAO.inserir(f);
		view.getPainelListagem().atualizarDados();
	}
	
	public void apagarFilme(Long id) {
		Filme f = new Filme();
		f.setId(id);
		
		filmeDAO.apagar(f);
		view.getPainelListagem().atualizarDados();
	}



}
