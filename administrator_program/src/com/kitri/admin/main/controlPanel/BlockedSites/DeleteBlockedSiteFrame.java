package com.kitri.admin.main.controlPanel.BlockedSites;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteBlockedSiteFrame extends JFrame {
	public ListOfBlockedSitesFrame lbs;
	
	private JPanel contentPane;
	private JTextField siteNameTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBlockedSiteFrame frame = new DeleteBlockedSiteFrame();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteBlockedSiteFrame () {
//		getContentPane().setLayout(null);
//		
//		JLabel siteName = new JLabel("\uC2F8\uC774\uD2B8\uBA85");
//		siteName.setBounds(80, 105, 46, 14);
//		getContentPane().add(siteName);
//		
//		siteNameTF = new JTextField();
//		siteNameTF.setBounds(136, 102, 86, 20);
//		getContentPane().add(siteNameTF);
//		siteNameTF.setColumns(10);
//		siteNameTF.requestFocus();
	}
	
	public DeleteBlockedSiteFrame(ListOfBlockedSitesFrame lbs) {
		this.lbs = lbs;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		
		JLabel siteName = new JLabel("\uC2F8\uC774\uD2B8\uBA85");
		siteName.setBounds(80, 105, 46, 14);
		getContentPane().add(siteName);
		
		siteNameTF = new JTextField();
		siteNameTF.setBounds(136, 102, 86, 20);
		getContentPane().add(siteNameTF);
		siteNameTF.setColumns(10);
		siteNameTF.requestFocus();
	}
}
