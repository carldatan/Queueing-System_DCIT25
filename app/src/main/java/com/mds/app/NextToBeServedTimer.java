package com.mds.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NextToBeServedTimer extends JPanel {
	JLabel customerToBeServed;
	private int timeRemaining;
	private Timer timer;
	private int seconds;
	private int minutes;
	JLabel time;

	NextToBeServedTimer() {
		// this.setBounds(0, -10, 1280, 400);
		this.setLayout(new GridLayout(2, 1));

		time = new JLabel();
		time.setFont(new Font("Arial", Font.BOLD, 100));

		customerToBeServed = new JLabel();
		customerToBeServed.setFont(new Font("Arial", Font.BOLD, 150));
		customerToBeServed.setForeground(Color.RED);
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (timeRemaining == 0) {
					customerToBeServed.setText("");
					time.setVisible(false);
					timer.stop();
				} else {
					minutes = timeRemaining / 60;
					seconds = timeRemaining % 60;
					String seconds_string = String.format("%02d", seconds);
					String minutes_string = String.format("%02d", minutes);
					time.setText(minutes_string + ":" + seconds_string);
					timeRemaining--;
				}
			}
		});

		this.add(customerToBeServed);
	}

	public void setCustomerToBeServed(String customer) {
		if (timer.isRunning())
			timer.stop();
		if (customer == "") {
			timer.stop();
			return;
		}

		customerToBeServed.setText(customer);
		timeRemaining = 180;
		timer.start();
	}

	public void showTimer() {
		time.setVisible(true);
	}

}
