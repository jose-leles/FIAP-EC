package br.com.fiap.pacman.jose;

public class Booster extends Item {

	private boolean invisible;
	
	public Booster(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isInvisible() { return invisible; }
	
	public void setInvisible(boolean invisible) { this.invisible = invisible; }

}
