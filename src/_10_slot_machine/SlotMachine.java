package _10_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton spin = new JButton();
	JLabel wins = new JLabel();
	Random one= new Random();
	Random two= new Random();
	Random three= new Random();
	int count = 0;
	
	void run() {
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(spin);
		
		frame.pack();
		spin.setText("Spin!");
		spin.addActionListener(this);
		
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		int num1 = one.nextInt(3)+1;
		int num2 = two.nextInt(3)+1;
		int num3 = three.nextInt(3)+1;
		
		if(e.getSource() == spin) {
			panel.removeAll();
			panel.add(spin);
			
			
			
			if(num1 == 1) {
				try {
					panel.add(createLabelImage("Lucky7.jpeg"));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				if(num2 == 1) {
				
						try {
							panel.add(createLabelImage("Lucky7.jpeg"));
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
				if(num3 == 1) {
					
						try {
							panel.add(createLabelImage("Lucky7.jpeg"));
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					}
		
				if(num1 == 2) {
					
					try {
						panel.add(createLabelImage("Luck$.png"));
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
		}
				if(num2 == 2) {
					
					try {
						panel.add(createLabelImage("Luck$.png"));
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(num3 == 2) {
					
					try {
						panel.add(createLabelImage("Luck$.png"));
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(num1 == 3) {
					
					try {
						panel.add(createLabelImage("diamond.png"));
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(num2 == 3) {
					
					try {
						panel.add(createLabelImage("diamond.png"));
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(num3 == 3) {
					
					try {
						panel.add(createLabelImage("diamond.png"));
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}
		frame.pack();
		if(num1 == num2 && num2 == num3) {
			JOptionPane.showMessageDialog(null, "You Win!");
			count++;
		}
		panel.add(wins);
		wins.setText("Wins: "+count);
		frame.pack();
	}
}
	

		
