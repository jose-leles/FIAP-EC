package br.com.fiap.louja.crud.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import br.com.fiap.louja.crud.controller.FilmeController;

public class Janela extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane abas = new JTabbedPane();
	
	private FilmeController filmeController = new FilmeController(this);
	
	private PainelCadastroEdicao painelCadastroEdicao = new PainelCadastroEdicao(filmeController);
	private PainelListagem painelListagem = new PainelListagem(filmeController);
	
	public Janela() {
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public void init() {
		filmeController.mockarDadosIniciais();
		
		painelCadastroEdicao.init();
		painelListagem.init();
		
		abas.add(painelCadastroEdicao, "Cadastro");
		abas.add(painelListagem, "Listagem" );
		
		add(abas);
		
		setVisible(true);
	}

	public PainelListagem getPainelListagem() { return painelListagem; 	}
	
	public PainelCadastroEdicao getPainelCadastroEdicao() { return painelCadastroEdicao; 	}

	
	

}
