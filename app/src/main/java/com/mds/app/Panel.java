package com.mds.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Container;

import javax.swing.JPanel;

public class Panel extends JPanel {
	Frame parent;

	Panel(Frame frame) {
		parent = frame;
		int height = (int) (parent.getHeight() * .75);
		this.setPreferredSize(new Dimension(parent.getWidth(), height));
		this.setBackground(Color.gray);
		this.setLayout(new GridLayout(1, 2));
	}
}
