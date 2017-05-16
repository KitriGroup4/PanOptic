package com.kitri.admin.main.employeePanel;

import javax.swing.JPanel;

import com.kitri.admin.main.employeePanel.EmployeeListFrame.EmployeeListFrame;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeJP extends JPanel {
	JButton empList;
	EmployeeListFrame empDetail;
	/**
	 * Create the panel.
	 */
	public EmployeeJP() {
		empDetail = new EmployeeListFrame();
		setLayout(new GridLayout(10, 1, 0, 0));
		empList = new JButton("\uC9C1\uC6D0\uB9AC\uC2A4\uD2B8");
		add(empList);
		
		empList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empDetail.setVisible(true);
			}
		});
	}

}
