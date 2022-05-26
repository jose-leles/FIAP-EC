package br.com.fiap.pacman.jose;

import java.time.Instant;

import javax.swing.ImageIcon;

public class Player extends GameObject {

	private int life;
	private int direction;
	private boolean invensible;
	private long invensibleStartTimestamp;
	
	public Player(int x, int y, int direction, ImageIcon background) {
		super(x, y, background);
		this.direction = direction;
	}
	
	public void move() {
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
	
	public int getDirection() { return life; }

	public void setDirection(int direction) { this.direction = direction; }

	public int getLife() { return life; }

	public void setLife(int life) { this.life = life; }

	public boolean isInvensible() { return invensible; }

	public void setInvensible(boolean invensible) { 
		this.invensible = invensible; 
        setInvensibleStartTimestamp(invensible? Instant.now().getEpochSecond() : 0);
	}

	public long getInvensibleStartTimestamp() {
		return invensibleStartTimestamp;
	}

	public void setInvensibleStartTimestamp(long invensibleStartTimestamp) {
		this.invensibleStartTimestamp = invensibleStartTimestamp;
	}

}
