package com.kitri.admin.main.customerPanel;

import javax.swing.JPanel;

import com.kitri.admin.main.customerPanel.UserInfoListFrame.UserInfoListFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CustomerJP extends JPanel {
	UserInfoListFrame userInfoList;
	JButton userList;
	/**
	 * Create the panel.
	 */
	public CustomerJP() {
		userInfoList = new UserInfoListFrame();
		setLayout(new GridLayout(10, 1, 0, 0));
		
		userList = new JButton("\uD68C\uC6D0\uB9AC\uC2A4\uD2B8");
		add(userList);
		
		userList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userInfoList.setVisible(true);
			}
		});
		
	}

}
