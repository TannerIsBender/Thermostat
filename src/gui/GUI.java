package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import temp.Controller;

/**
 * @author Tanner
 *
 */
public class GUI {
    Border blackline = BorderFactory.createLineBorder(Color.black);

    public static int[] preset = {60, 80, 100};

    private JButton high;
    private JButton medium;
    private JButton low;

    private JLabel displayTemp = new JLabel("" + Controller.temp);

    //Slider
    private static final int FPS_MIN = 0;
    private static final int FPS_MAX = 30;
    private static final int FPS_INIT = Controller.temp;    //initial frames per second
    JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
            FPS_MIN, FPS_MAX, FPS_INIT);

    public void displaySlider(Container pane) {
        pane.add(framesPerSecond);
        framesPerSecond.setMajorTickSpacing(10);
        framesPerSecond.setMinorTickSpacing(1);
        framesPerSecond.setPaintTicks(true);
        framesPerSecond.setPaintLabels(true);
        framesPerSecond.setPaintLabels(false);
        framesPerSecond.setBorder(
                BorderFactory.createEmptyBorder(0,0,10,0));
        framesPerSecond.setBounds(40, 285, 400, 50);
    }


    /**
     * Adds objects to the Jframe
     * @param pane
     */
    private void paneAdd(Container pane) {
    	pane.add(high);
    	pane.add(medium);
    	pane.add(low);
        pane.add(displayTemp);
    }
    
    private void daBounds() {
    	high.setBounds(20, 95, 50, 30);
    	medium.setBounds(20, 150, 50, 30);
    	low.setBounds(20, 205, 50, 30);
        displayTemp.setBounds(150, 50, 200, 250);
    }

    private void displayTemperature() {
        displayTemp = new JLabel("" + Controller.temp);
        displayTemp.setFont(new Font("sans-serif", Font.PLAIN, 180));
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
                if (Controller.setTemp(preset[0])) {
                    Controller.temp = preset[0];
                }
			}
		});
    	
    	medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                if (Controller.setTemp(preset[1])) {
                    Controller.temp = preset[1];
                }
			}
		});
    	low.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                if (Controller.setTemp(preset[2])) {
                    Controller.temp = preset[2];
                }
			}
		});
    }
    
	public GUI() {
        JFrame frame = new JFrame("Thermostat");
        frame.setSize(500, 400);
        Container pane = frame.getContentPane();
        pane.setLayout(null);
        new JPanel();

        displaySlider(pane);
        buttonNames();
        displayTemperature();
        daBounds();
        paneAdd(pane);

        buttonActions();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
