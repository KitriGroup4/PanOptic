package com.kitri.admin.main.control;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class ControlJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public ControlJP() {
		setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("\uC720\uD574\uD504\uB85C\uADF8\uB7A8 \uCC28\uB2E8");
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\uB098\uC774\uC81C\uD55C");
		add(btnNewButton);

	}

}
