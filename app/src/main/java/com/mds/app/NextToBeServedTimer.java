package com.mds.app;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NextToBeServedTimer extends JPanel {
    JLabel customerToBeServed;
    LinkedList<Integer> queue;
    AtomicInteger timeRemaining;

    NextToBeServedTimer(LinkedList<Integer> queue) {
        this.setBounds(0, -10, 1280, 400);
        this.setLayout(new FlowLayout());
        timeRemaining = new AtomicInteger(30);

        customerToBeServed = new JLabel();
        customerToBeServed.setText("Next Customer: ");
        customerToBeServed.setBounds(100, 30, 200, 200);
        customerToBeServed.setFont(new Font("Arial", Font.BOLD, 50));
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining.get() == 0) {
                    customerToBeServed.setText("Next Customer: ");
                } else {
                    timeRemaining.decrementAndGet();
                }
            }
        });

        timer.start();
        this.add(customerToBeServed);
    }

    public String setCustomerToBeServed(LinkedList<Integer> queue) {
        return String.valueOf(queue.peekFirst());
    }
}
