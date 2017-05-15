package com.kitri.admin.main.leftoverPanel;

import javax.swing.JPanel;

import com.kitri.admin.main.fixCon.Fix;
import com.kitri.admin.main.leftoverPanel.LeftOverListFrame.LeftOverListFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LeftOverJP extends JPanel {
	JButton leftOverBtn;
	LeftOverListFrame leftList;

	/**
	 * Create the panel.
	 */
	public LeftOverJP() {
		leftList = new LeftOverListFrame();
		setLayout(new GridLayout(10, 1, 0, 0));

		leftOverBtn = new JButton("\uC7AC\uACE0\uAD00\uB9AC");
		add(leftOverBtn);
		leftOverBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				leftList.setVisible(true);
			}
		});
	}

}
