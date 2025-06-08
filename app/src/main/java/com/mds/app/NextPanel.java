package com.mds.app;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.EmptyBorder;

class NextPanel extends JPanel {
	NextToBeServedTimer nextCustomer;
	JPanel nextContainer;
	JLabel next;
	JLabel label;

	NextPanel() {
		nextCustomer = new NextToBeServedTimer();
		label = new JLabel("Now Serving");
		label.setBorder(new EmptyBorder(10, 20, 10, 20));
		label.setFont(new Font("Arial", Font.BOLD, 60));
		nextContainer = new JPanel();
		nextContainer.setPreferredSize(new Dimension(320, 250));
		nextContainer.setBorder(BorderFactory.createBevelBorder(1));
		this.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		this.add(label);
		nextContainer.add(nextCustomer);
		this.add(nextContainer);
		this.setBackground(Color.LIGHT_GRAY);
	}

	public void showTimer() {

	}

}
