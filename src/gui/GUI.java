package gui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 */
public class GUI {

	public GUI() {
		 	JFrame frame = new JFrame("Thermostat");
	        frame.setSize(500, 400);
		 	Container pane = frame.getContentPane();
		 	pane.setLayout(null);
		 	new JPanel();

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);	
	}
}
