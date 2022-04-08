package br.com.fiap.pacman.jose;

public abstract class GameObject {
	private int x;
	private int y;
	private int screenSize;
	
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public int getY() { return y; }
	
	public void setY(int y) { if(y > 0 && y < screenSize) this.y = y; }
	
	public int getX() { return x; }
	
	public void setX(int x) { if(x > 0 && x < screenSize) this.x = x; }

	public int getScreenSize() { return screenSize; }

	public void setScreenSize(int tamanhoTela) { this.screenSize = tamanhoTela; }
	
	
}
