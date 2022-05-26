package br.com.fiap.pacman.jose;

import javax.swing.ImageIcon;

public class Bomb extends Item {
	
	boolean exploded;

	public Bomb(int x, int y, ImageIcon background) {
		super(x, y, background);
	}
	
	public void setExploded(boolean exploded) {
		setVisible(!exploded);
		this.exploded = exploded;
	}
	
	public boolean isExploded() {
		return exploded;
	}

}
