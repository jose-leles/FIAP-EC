package br.com.fiap.jogo;

public class Main {

	public static void main(String[] args) {
		Fase fase = new Fase();
		JogadorMago mago = new JogadorMago("a");
		JogadorGuerreiro guerreiro = new JogadorGuerreiro("a");
		BolaDeFogo bolaDeFogo = new BolaDeFogo();
		Dragao dragao = new Dragao();
		
		fase.carregar(mago);
		fase.carregar(guerreiro);
		fase.carregar(bolaDeFogo);
		fase.carregar(dragao);
		

	}

}
