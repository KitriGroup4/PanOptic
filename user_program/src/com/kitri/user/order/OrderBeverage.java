package com.kitri.user.order;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class OrderBeverage extends JPanel {
	private JButton beverageNamebtn[];
	/**
	 * Create the panel.
	 */
	public OrderBeverage() {
		setLayout(new GridLayout(5, 5, 10, 10));
		
		beverageNamebtn = new JButton[25];
		int len = beverageNamebtn.length;
		
		for (int i = 0; i < len; i++) {
			beverageNamebtn[i] = new JButton("drink");
			add(beverageNamebtn[i]);
		
		}
		
		
	}

}
