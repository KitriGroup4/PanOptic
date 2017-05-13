package com.kitri.admin.main;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class EmployeeJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmployeeJP() {
		setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton button = new JButton("\uC9C1\uC6D0\uD604\uD669");
		add(button);
		
		JButton btnNewButton = new JButton("\uC2DC\uAE09\uD604\uD669");
		add(btnNewButton);

	}

}
