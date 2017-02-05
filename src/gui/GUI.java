package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import temp.Controller;

/**
 * @author Tanner
 *
 */
public class GUI {
	Controller c;
    private JButton high;
    private JButton medium;
    private JButton low;

    
    /**
     * Adds objects to the Jframe
     * @param pane
     */
    private void paneAdd(Container pane) {
    	pane.add(high);
    	pane.add(medium);
    	pane.add(low);
    }
    
    private void daBounds() {
    	high.setBounds(20, 95, 50, 30);
    	medium.setBounds(20, 150, 50, 30);
    	low.setBounds(20, 205, 50, 30);
    }
    
    private void buttonNames() {
    	high = new JButton("H");
    	medium = new JButton("M");
    	low = new JButton("L");
    }
    
    private void buttonActions() {
    	high.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setPreset(0);
			}
		});
    	
    	medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setPreset(1);
			}
		});
    	low.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setPreset(2);
			}
		});
    }
    
	public GUI() {
		 	JFrame frame = new JFrame("Thermostat");
	        frame.setSize(500, 400);
		 	Container pane = frame.getContentPane();
		 	pane.setLayout(null);
		 	new JPanel();
		 	buttonNames();
		 
		 	daBounds();
		 	paneAdd(pane);

		 	buttonActions();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);	
	}
}
