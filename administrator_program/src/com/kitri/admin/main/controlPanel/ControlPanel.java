package com.kitri.admin.main.controlPanel;

import javax.swing.JPanel;

import com.kitri.admin.main.controlPanel.BlockedSites.ListOfBlockedSitesFrame;
import com.kitri.admin.main.controlPanel.ageRestriction.AgeRestrictionFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControlPanel extends JPanel implements ActionListener {
	JButton blockedSitesButton;
	JButton ageRestrictionButton;
	ListOfBlockedSitesFrame blockedSitesFrame;
	AgeRestrictionFrame ageRestrictionFrame;
	
	/**
	 * Create the panel.
	 */
	public ControlPanel() {
		blockedSitesFrame = new ListOfBlockedSitesFrame();
		ageRestrictionFrame = new AgeRestrictionFrame();
		
		setLayout(new GridLayout(10, 1, 0, 0));
		
		blockedSitesButton = new JButton("\uC720\uD574\uC2F8\uC774\uD2B8\uCC28\uB2E8 \uAD00\uB9AC");
		add(blockedSitesButton);
		
		ageRestrictionButton = new JButton("\uB098\uC774\uC81C\uD55C");
		add(ageRestrictionButton);
		
		blockedSitesButton.addActionListener(this);
		ageRestrictionButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == blockedSitesButton) {
			blockedSitesFrame.setVisible(true);
		}
		else if (obj == ageRestrictionButton) {
			ageRestrictionFrame.setVisible(true);
		}
	}
	
	

}
