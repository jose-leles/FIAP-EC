package br.fiap.com.br.aula6;

import java.awt.Color;

import javax.swing.JLabel;

public class JoseLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	
	public JoseLabel(String texto) {
		this.setText(texto);
		init();
	}
	
	private void init() {
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setForeground(new Color(255,0,150));
	}
	
	
	
}








//tela.addKeyListener(new KeyListener() {
//	@Override
//	public void keyTyped(KeyEvent e) {}
//	
//	@Override
//	public void keyReleased(KeyEvent e) {}
//	
//	@Override
//	public void keyPressed(KeyEvent e) {
//		System.out.println("Teste "+ e.getKeyChar());
//	}
//});
