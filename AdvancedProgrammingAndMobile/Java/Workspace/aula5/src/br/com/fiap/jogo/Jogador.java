package br.com.fiap.jogo;

public abstract class Jogador extends ElementoMovivel {
	
	private String nome;
	private int xp;
	private int hp;
	private boolean envenenado;
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	
	public int getXp() {
		return xp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public boolean isEnvenenado() {
		return envenenado;
	}
	
	public void receberDano(int pontos) {
		this.hp -= pontos;
	}
	
	public void receberCura(int pontos){
		this.hp += pontos;
	}
	
	public void ganharExperiencia(int pontos){
		this.xp += pontos;
	}
	
	public void receberAntidoto(){
		this.envenenado = false;
	}


	public String getNome() {
		return nome;
	}
	
	

}
