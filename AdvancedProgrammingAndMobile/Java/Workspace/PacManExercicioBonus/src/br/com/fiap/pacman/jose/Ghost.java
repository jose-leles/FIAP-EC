package br.com.fiap.pacman.jose;

import javax.swing.ImageIcon;

public class Ghost extends GameObject {

	private int direction;
	
	public Ghost(int x, int y, int direction, ImageIcon background) {
		super(x, y, background);
		this.direction = direction;
	}
	
	public void move() {
		int[] directions = {0, 90, 180, 270};
		this.direction = directions[(int) (Math.random() * 3)];
		if(canMove()) {
			if(direction == 0)
				setY(getY() - 10);
			
			if(direction == 90)
				setX(getX() + 10);
			
			if(direction == 180)
				setY(getY() + 10);
			
			if(direction == 270)
				setX(getX() - 10);
		}
	}
	
	public boolean canMove() {
		if(direction == 0)
			return getY() - 10 > 0;
		
		if(direction == 90)
			return getX() + 10 < getScreenSize();
		
		if(direction == 180)
			return getY() + 10 < getScreenSize();
		
		if(direction == 270)
			return getX() - 10 > 0;
		
		return false;
	}
	
	public int getDirection() { return direction; }

	public void setDirection(int direction) { this.direction = direction; }

}
