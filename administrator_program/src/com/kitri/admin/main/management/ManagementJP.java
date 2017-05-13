package com.kitri.admin.main.management;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class ManagementJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagementJP() {
		setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton wageManagement = new JButton("\uAE09\uC5EC\uAD00\uB9AC");
		add(wageManagement);
		
		JButton addEmployee = new JButton("\uC9C1\uC6D0\uB4F1\uB85D");
		add(addEmployee);
		
		JButton assetManagement = new JButton("\uC790\uC0B0\uAD00\uB9AC");
		add(assetManagement);

	}

}
