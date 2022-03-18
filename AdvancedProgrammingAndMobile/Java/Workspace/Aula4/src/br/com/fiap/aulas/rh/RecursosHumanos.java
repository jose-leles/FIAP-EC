package br.com.fiap.aulas.rh;

public class RecursosHumanos {
	
	public static void main(String[] args) {
		Engenheiro engenheiro = new Engenheiro();
		engenheiro.setSalarioBase(5000);
		System.out.println("Salario do engenheiro = " + engenheiro.calcularSalario());
		
		Presidente presidente = new Presidente();
		presidente.setValorDasCotas(10000);
		presidente.setSalarioBase(8000);
		System.out.println("Salario do presidente = " + presidente.calcularSalario());
		
		Presidente presidenteRegional = new Presidente();
		presidenteRegional.setValorDasCotas(2000);
		presidenteRegional.setSalarioBase(5000);
		System.out.println("Salario do presidenteRegional = " + presidenteRegional.calcularSalario());

		Gerente gerente = new Gerente();
		gerente.setSalarioBase(3000);
		gerente.setBonus(1500);
		System.out.println("Salario do gerente = " + gerente.calcularSalario());
		
		FolhaDePagamento folhaDePagamento = new FolhaDePagamento();
		folhaDePagamento.registrar(presidente);
		folhaDePagamento.registrar(presidenteRegional);
		folhaDePagamento.registrar(gerente);
		folhaDePagamento.registrar(engenheiro);
		System.out.println("TOTAL = " + folhaDePagamento.getPagamentoTotal());

		gerente.setSenha("123456");
		folhaDePagamento.logar(gerente);

		Cliente cliente = new Cliente();
		cliente.setSenha("123456");
		folhaDePagamento.logar(cliente);
		
		
	}

}
