package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	
	JButton one = new JButton();
	JButton two = new JButton();
	
	public static void main(String[] args) {
	ChuckleClicker click = new ChuckleClicker();
	click.makeButtons();
	}
	void makeButtons(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		one.setText("joke");
		two.setText("punchline");
		frame.add(panel);
		panel.add(one);
		panel.add(two);
		frame.pack();
		one.addActionListener(this);
		two.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == two) {
			JOptionPane.showMessageDialog(null, "A stick");
		}
		if(e.getSource() == one) {
			JOptionPane.showMessageDialog(null, "What do you call a boomerang that won’t come back?");
		}
	}
}
