package com.mds.app;

import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {

	Frame(String title) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = (int) (screenSize.width * .50);
		int height = (int) (screenSize.height * .70);
		this.setSize(width, height);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
	}

	public void addQueue(LinkedList<Integer> queue, JPanel panel) {
		Random random = new Random();
		int max = 500;
		int min = 1;
		int randomInt = random.nextInt(max - min) + min;
		while (queue.contains(randomInt)) {
			randomInt = random.nextInt(max - min) + min;

		}
		queue.add(randomInt);
		updatePanel(queue, panel);
	}

	public void updatePanel(LinkedList<Integer> queue, JPanel panel) {

		JLabel label = new JLabel(String.valueOf(queue.peekLast()));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 60));
		label.setBackground(new Color(0x050505));
		label.setOpaque(true);
		panel.add(label);

		panel.repaint();
		panel.revalidate();
	}

	public String popQueue(LinkedList<Integer> queue, JPanel panel) {
		int n = 0;
		if (queue.size() > 0) {
			n = queue.remove();
			removeLabel(panel);
			return String.valueOf(n);
		}
		return "";

	}

	public void removeLabel(JPanel panel) {

		if (panel.getComponentCount() > 0 && panel.getComponent(0) instanceof JLabel) {
			panel.remove(0);
			panel.repaint();
			panel.revalidate();
		}
	}
}
