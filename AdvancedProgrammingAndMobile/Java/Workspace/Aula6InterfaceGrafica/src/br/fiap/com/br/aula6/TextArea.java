package br.fiap.com.br.aula6;


import javax.swing.JTextArea;


public class TextArea extends JTextArea {
	
	private static final long serialVersionUID = 1L;
	private int colunas = 30;
	private int linhas = 10;
	
	public TextArea() {

		init();
	}

	private void init() {
		this.setColumns(colunas);
		this.setRows(linhas);
		this.setBorder(BorderFactory.create());
	}

}
