package br.com.fiap.aulas.rh;

public class Cliente implements FuncionarioAutenticavel {
	
	private String senha;

	@Override
	public boolean autenticar(String senha) {
		if(this.senha == senha) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
