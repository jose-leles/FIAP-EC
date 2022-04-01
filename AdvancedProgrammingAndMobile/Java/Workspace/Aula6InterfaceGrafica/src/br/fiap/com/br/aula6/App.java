package br.fiap.com.br.aula6;


import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName()
			);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		JFrame tela = new JFrame("Microsofreft Windows");
		tela.setLayout(new FlowLayout());
		
		JoseLabel label = new JoseLabel("Bem venidos");
		tela.add(label);
		
		InputText input = new InputText();
		tela.add(input);
		
		TextArea textArea = new TextArea();
		tela.add(textArea);
		
		JCheckBox checkbox = new JCheckBox();
		tela.add(checkbox);
		
		JRadioButton radio1 = new JRadioButton();
		radio1.setText("Pix");
		tela.add(radio1);
		
		JRadioButton radio2 = new JRadioButton();
		radio2.setText("Boleto");
		tela.add(radio2);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radio1);
		radioGroup.add(radio2);
		
		String[] cidades = { "A vista", "2x sem juros", "36x 110% de juros" };
		JComboBox<String> comboBox = new JComboBox<String>(cidades);
		tela.add(comboBox);
	
		tela.setSize(400,400);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setVisible(true);
	}
	
}
