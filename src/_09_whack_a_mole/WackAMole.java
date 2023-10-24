package _09_whack_a_mole;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WackAMole {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b;
	Random x= new Random();
	
	
	void run() {
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(new GridLayout(3, 8));
		makeButtons();
		
	}
	
	void makeButtons() {
		int mole = x.nextInt(19);
		for(int x = 0; x<18; x++) {
			b = new JButton();
			panel.add(b);
			if(x == mole) {
				b.setText("mole!");
			}
		}
	}
	
}
