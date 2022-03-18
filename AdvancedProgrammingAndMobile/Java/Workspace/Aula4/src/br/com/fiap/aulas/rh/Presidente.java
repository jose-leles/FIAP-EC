package br.com.fiap.aulas.rh;

public final class Presidente extends Empregado implements FuncionarioAutenticavel {

	private double valorDasCotas;
	private String senha;
	
	@Override
	public double calcularSalario() {
		return getSalarioBase() + valorDasCotas;
	}

	public double getValorDasCotas() {
		return valorDasCotas;
	}

	public void setValorDasCotas(double valorDasCotas) {
		this.valorDasCotas = valorDasCotas;
	}

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
