package br.com.fiap.pacman.jose;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.security.Timestamp;
import java.time.Instant;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.w3c.dom.css.Rect;

public class Game extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Player player = new Player(50, 50, 180, new ImageIcon("src/images/pacman.png"));
	private Ghost ghost1 = new Ghost(0,0,0, new ImageIcon("src/images/ghost.png"));
	private Ghost ghost2 = new Ghost(500,0,0, new ImageIcon("src/images/ghost.png"));
	private Ghost ghost3 = new Ghost(0,500,0, new ImageIcon("src/images/ghost.png"));
	private Ghost ghost4 = new Ghost(500,500,0, new ImageIcon("src/images/ghost.png"));
	private Bomb bomb = new Bomb(100,100, new ImageIcon("src/images/bomb.png"));
	private Booster booster = new Booster(400, 400, new ImageIcon("src/images/booster.png"));


	private final int SCREENSIZE = 600;
	private int speed = 1;
	
	public static void main(String[] args) {
		new Game().init();
	}

	private void init() {
		setLayout(null);
		player.setScreenSize(SCREENSIZE);
		player.setLife(15);

		ghost1.setScreenSize(SCREENSIZE);
		ghost2.setScreenSize(SCREENSIZE);
		ghost3.setScreenSize(SCREENSIZE);
		ghost4.setScreenSize(SCREENSIZE);
		
		
		add(player);
		add(ghost1);
		add(ghost2);
		add(ghost3);
		add(ghost4);
		add(bomb);
		add(booster);

		render();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SCREENSIZE + 100, SCREENSIZE + 100);
		setVisible(true);
		addKeyListener(this);

		run();
	}

	private void render() {
		
		updateLocation(player);
		updateLocation(ghost1);
		updateLocation(ghost2);
		updateLocation(ghost3);
		updateLocation(ghost4);
		updateLocation(bomb);
		updateLocation(booster);
		setTitle("Life: " + player.getLife());
		SwingUtilities.updateComponentTreeUI(this);

	}

	private void updateLocation(GameObject object) {
		object.setBounds(object.getX(), object.getY(), 50, 50);
		ImageIcon myImage = (ImageIcon) object.getIcon();
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(object.getWidth(), object.getHeight(),Image.SCALE_SMOOTH);
        object.setIcon( new ImageIcon(newImg) );
	}

	private void run() {
		while (player.getLife() > 0) {
			//player sempre fica 5 segundos invencivel
			if(player.isInvensible() && (Instant.now().getEpochSecond() - player.getInvensibleStartTimestamp()) > 5) {
				player.setInvensible(false);
			}
			
			player.move();
			ghost1.move();
			ghost2.move();
			ghost3.move();
			ghost4.move();
			
			if (player.isCollidedWith(bomb) && !bomb.isExploded()) {
                bomb.setExploded(true);
                player.setLife(player.getLife() - 1);
            }
            if (player.isCollidedWith(booster)) {
            	player.setInvensible(true);
                booster.setInvisible(true);
            }
            if (
            		player.isCollidedWith(ghost1) 
            		|| player.isCollidedWith(ghost2)
            		|| player.isCollidedWith(ghost3)
            		|| player.isCollidedWith(ghost4)
            	) {
                player.setLife(player.getLife() - 1);
            }
				
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == '8' || c == 'w') player.setDirection(0);	
		if (c == '6' || c == 'd') player.setDirection(90);	
		if (c == '2' || c == 's') player.setDirection(180);	
		if (c == '4' || c == 'a') player.setDirection(270);	
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	

	
}
