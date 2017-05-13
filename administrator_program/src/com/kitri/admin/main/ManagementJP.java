package com.kitri.admin.main;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class ManagementJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagementJP() {
		setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("\uAE09\uC5EC\uD604\uD669");
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\uC790\uC0B0");
		add(btnNewButton);

	}

}
