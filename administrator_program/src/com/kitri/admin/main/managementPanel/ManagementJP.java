package com.kitri.admin.main.managementPanel;

import javax.swing.JPanel;

import com.kitri.admin.main.managementPanel.RegisterEmployeeFrame.RegisterEmployeeFrame;
import com.kitri.admin.main.managementPanel.WorkWageInfoFrame.WorkWageInfoFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ManagementJP extends JPanel {
	RegisterEmployeeFrame regEmp;
	WorkWageInfoFrame wageInfo;
	JButton wageManBtn;
	JButton regEmpBtn;

	/**
	 * Create the panel.
	 */
	
	public ManagementJP() {
		regEmp = new RegisterEmployeeFrame();
		wageInfo = new WorkWageInfoFrame();

		setLayout(new GridLayout(10, 1, 0, 0));

		wageManBtn = new JButton("\uAE09\uC5EC\uAD00\uB9AC");
		add(wageManBtn);

		regEmpBtn = new JButton("\uC9C1\uC6D0\uB4F1\uB85D");
		add(regEmpBtn);

		JButton assetManagement = new JButton("\uC790\uC0B0\uAD00\uB9AC");
		add(assetManagement);

		wageManBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wageInfo.setVisible(true);
			}
		});
		
		regEmpBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				regEmp.setVisible(true);
			}
		});

	}

}
