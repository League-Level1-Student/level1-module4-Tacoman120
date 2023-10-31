package _09_whack_a_mole;

import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WackAMole implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b;
	JButton mole;
	Random x= new Random();
	int moleCount = 0;
	int missCount = 0;
	Date date = new Date();
	
	
	void run() {
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(new GridLayout(3, 8));
		makeButtons(x);
		
	}
	
	void makeButtons(Random ran) {
		int num = ran.nextInt(19);
		for(int x = 0; x<18; x++) {
			if(x == num) {
				mole = new JButton();
				panel.add(mole);
				mole.setText("mole!");
				mole.addActionListener(this);
			}else {
				b = new JButton();
				panel.add(b);
				b.addActionListener(this);
			}
		}
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonClicked = (JButton) e.getSource();
		
		
		if(buttonClicked == mole) {
				moleCount++;
				if(moleCount == 10) {
					endGame(date,moleCount);
				}
				playSound("tada.wav");
				panel.removeAll();
				makeButtons(x);
		}else {
			
			missCount++;
			if(missCount == 1) {
				speak("you missed!");
			}
			if(missCount == 2) {
				speak("Try again");
			}
			if(missCount == 3) {
				speak("You'll get it next time");
			}
			if(missCount == 4) {
				speak("One more chance");
			}
			if(missCount == 5) {
				speak("Game Over");
			}
			if(missCount == 5) {
				endGame(date,moleCount);
			}
			panel.removeAll();
			makeButtons(x);
		}
	}
	
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	}
	
	 static void speak(String words) {
	        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
	            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
	                    + words + "');\"";
	            try {
	                Runtime.getRuntime().exec( cmd ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        } else {
	            try {
	                Runtime.getRuntime().exec( "say " + words ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	 private void playSound(String fileName) { 
		    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		    sound.play();
		}
	 
}
