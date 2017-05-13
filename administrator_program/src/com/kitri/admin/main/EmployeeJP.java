package com.kitri.admin.main;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmployeeJP() {
		setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton button = new JButton("\uC9C1\uC6D0\uB9AC\uC2A4\uD2B8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(button);

	}

}
