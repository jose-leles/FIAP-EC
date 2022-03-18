package br.com.fiap.aulas.rh;

public interface FuncionarioAutenticavel {
	
	boolean autenticar(String senha);
	
	void setSenha(String senha);

}
