package _06_calculator;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	
	JFrame frame =  new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton mult = new JButton();
	JButton divs = new JButton();
	JButton addi = new JButton();
	JButton subt = new JButton();
	JTextField one;
	JTextField two;
	
	public void setup() {
		
		one = new JTextField(4);
		two = new JTextField(4);
		label.setSize(25, 25);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		addi.setText("addition");
		subt.setText("subtraction");
		mult.setText("multiplication");
		divs.setText("division");
		panel.add(one);
		panel.add(two);
		panel.add(addi);
		panel.add(subt);
		panel.add(mult);
		panel.add(divs);
		frame.add(panel);
		panel.add(label);
		frame.pack();
		addi.addActionListener(this);
		subt.addActionListener(this);
		mult.addActionListener(this);
		divs.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String oneText = this.one.getText();
		String twoText = this.two.getText();
		double oneNum = Double.valueOf(oneText);
		double twoNum = Double.valueOf(twoText);
		if(e.getSource() == addi) {
			label.setText(String.valueOf(add(oneNum, twoNum)));
		}if(e.getSource() == subt) {
			label.setText(String.valueOf(subtract(oneNum, twoNum)));
		}if(e.getSource() == mult) {
			label.setText(String.valueOf(multiply(oneNum, twoNum)));
		}if(e.getSource() == divs) {
			label.setText(String.valueOf(divide(oneNum, twoNum)));
		}
	}
	double multiply(double a, double b){
		double c = a*=b;
		return c;
		
	}double subtract(double a, double b){
		double c = a-=b;
		return c;
		
	}double add(double a, double b){
		double c = a+=b;
		return c;
		
	}double divide(double a, double b){
		double c = a/=b;
		return c;
		
	}
	
	
}
