package br.com.fiap.pacman.jose;

import javax.swing.ImageIcon;

public class Booster extends Item {

	private boolean invisible;
	
	public Booster(int x, int y, ImageIcon background) {
		super(x, y, background);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isInvisible() { return invisible; }
	
	public void setInvisible(boolean invisible) { 
		super.setVisible(!invisible);
		this.invisible = invisible; 
	}

}
