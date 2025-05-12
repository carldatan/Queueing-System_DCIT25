package com.mds.app;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NextToBeServedTimer extends JPanel {
    JLabel customerToBeServed;
    LinkedList<Integer> queue;
    private int timeRemaining;
    private Timer timer;

    NextToBeServedTimer(LinkedList<Integer> queue) {
        this.setBounds(0, -10, 1280, 400);
        this.setLayout(new FlowLayout());
        timeRemaining = 30;

        customerToBeServed = new JLabel();
        customerToBeServed.setText("Next Customer: ");
        customerToBeServed.setBounds(100, 30, 200, 200);
        customerToBeServed.setFont(new Font("Arial", Font.BOLD, 50));
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining == 0) {
                    customerToBeServed.setText("Next Customer: ");
                    timer.stop();
                } else {
                    timeRemaining--;
                }
            }
        });

        timer.start();
        this.add(customerToBeServed);
    }

    public void setCustomerToBeServed(String customer) {
        if (timer.isRunning())
            timer.stop();

        customerToBeServed.setText("Next Customer: " + customer);
        timeRemaining = 30;
        timer.start();
    }

}
