package br.com.fiap.pacman.jose;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GameObject extends JLabel {

	private static final long serialVersionUID = 1L;
	private int screenSize;
	
	
	public GameObject(int x, int y, ImageIcon background) {
		super(background);
		super.setBounds(x, y, 50, 50); 
		setX(x);
		setY(y);
	}
	
	public boolean isCollidedWith(GameObject element) {
		return this.getBounds().intersects(element.getBounds());
	}
	
	
	public void setY(int y) { 
		if(y > 0 && y < screenSize) {
			super.setBounds(getX(), y, getWidth(), getHeight()); 
		}
	}

	public void setX(int x) { 
		if(x > 0 && x < screenSize) {
			super.setBounds(x, getY(), getWidth(), getHeight()); 
		} 
	}

	public int getScreenSize() { 
		return screenSize; 
	}

	public void setScreenSize(int tamanhoTela) { this.screenSize = tamanhoTela; }
	
	
}
