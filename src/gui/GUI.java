package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tech.Battery;
import tech.Controller;

/**
 * @author Tanner
 *
 */
public class GUI {
    Border blackline = BorderFactory.createLineBorder(Color.black);

    public static int[] preset = {100, 80, 60};

    private JButton high;
    private JButton medium;
    private JButton low;

    private JLabel displayTemp = new JLabel("" + Controller.temp);

    /* Slider */
    private static final int ticksStart = 60;
    private static final int ticksEnd = 101;
    //initial frames per second
    private static int tickInit = Controller.temp;
    JSlider tickMarks = new JSlider(JSlider.HORIZONTAL,
            ticksStart, ticksEnd, tickInit);

    public void displaySlider(Container pane) {
        pane.add(tickMarks);
        tickMarks.setMajorTickSpacing(4);
        tickMarks.setMinorTickSpacing(1);
        tickMarks.setPaintTicks(true);
        tickMarks.setPaintLabels(false);
        tickMarks.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        tickMarks.setBounds(110, 195, 235, 30);
    }

    public void adjustSlider() {
        tickMarks.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Controller.temp = tickMarks.getValue();
                tickInit = Controller.temp;
                displayTemperature();
//                System.out.println("Slider value: " + tickMarks.getValue());
//                System.out.println("Temp value: " + Controller.temp);
            }
        });
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
    	high.setBounds(20, 65, 50, 30);
    	medium.setBounds(20, 120, 50, 30);
    	low.setBounds(20, 185, 50, 30);
        displayTemp.setBounds(150, -28, 270, 250);
    }

    private void displayTemperature() {
//        System.out.println("" + Controller.temp);
        displayTemp.setText("" + Controller.temp);
        displayTemp.setFont(new Font("sans-serif", Font.PLAIN, 160));
    }

    private void displayBatteryLife() {
        displayTemp.setText("" + (int) Battery.getBattery() + " %");
        displayTemp.setFont(new Font("sans-serif", Font.PLAIN, 16));
    }

    private void buttonNames() {
    	high = new JButton("H");
    	medium = new JButton("M");
    	low = new JButton("L");
    }

    private void presetClick(int n) {
        Controller.temp = preset[n];
        tickMarks.setValue(preset[n]);
        displayTemperature();
    }

    private void buttonActions() {
    	high.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                if (Controller.setTemp(preset[0])) {
                    presetClick(0);
                }
			}
		});
    	
    	medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                if (Controller.setTemp(preset[1])) {
                    presetClick(1);
                }
			}
		});
    	low.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                if (Controller.setTemp(preset[2])) {
                    presetClick(2);
                }
			}
		});
    }
    
	public GUI() {
        JFrame frame = new JFrame("Thermostat");
        frame.setSize(500, 300);
        Container pane = frame.getContentPane();
        pane.setLayout(null);
        new JPanel();
        adjustSlider();

        displaySlider(pane);
        buttonNames();
        displayTemperature();
        daBounds();
//        displayBatteryLife();
        paneAdd(pane);

        buttonActions();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
