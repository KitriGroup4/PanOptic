package com.kitri.admin.main;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class CustomerJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public CustomerJP() {
		setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\uD604\uD669");
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\uBE14\uB799\uB9AC\uC2A4\uD2B8");
		add(btnNewButton);

	}

}
