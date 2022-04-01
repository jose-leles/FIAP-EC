package br.fiap.com.br.aula6;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public abstract class BorderFactory {
	
	public static Border create() {
		return new LineBorder(new Color(50,50,50));
	}

}
