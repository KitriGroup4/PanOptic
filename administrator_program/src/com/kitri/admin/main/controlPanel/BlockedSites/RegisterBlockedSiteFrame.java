package com.kitri.admin.main.controlPanel.BlockedSites;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegisterBlockedSiteFrame extends JFrame {
	public ListOfBlockedSitesFrame lbs;
	
	private JPanel contentPane;
	private JTextField urlTF;
	private JTextField siteNameTF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterBlockedSiteFrame frame = new RegisterBlockedSiteFrame();
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
	public RegisterBlockedSiteFrame () {
//		getContentPane().setLayout(null);
//		
//		JLabel urlL = new JLabel("URL");
//		urlL.setBounds(93, 67, 46, 14);
//		getContentPane().add(urlL);
//		
//		JLabel siteNameL = new JLabel("\uC2F8\uC774\uD2B8\uBA85");
//		siteNameL.setBounds(93, 102, 46, 14);
//		getContentPane().add(siteNameL);
//		
//		urlTF = new JTextField();
//		urlTF.setBounds(164, 64, 86, 20);
//		getContentPane().add(urlTF);
//		urlTF.setColumns(10);
//		urlTF.requestFocus();
//		
//		siteNameTF = new JTextField();
//		siteNameTF.setBounds(164, 99, 86, 20);
//		getContentPane().add(siteNameTF);
//		siteNameTF.setColumns(10);
		
	}
	
	public RegisterBlockedSiteFrame(ListOfBlockedSitesFrame lbs) {
		this.lbs= lbs;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		
		JLabel urlL = new JLabel("URL");
		urlL.setBounds(93, 67, 46, 14);
		getContentPane().add(urlL);
		
		JLabel siteNameL = new JLabel("\uC2F8\uC774\uD2B8\uBA85");
		siteNameL.setBounds(93, 102, 46, 14);
		getContentPane().add(siteNameL);
		
		urlTF = new JTextField();
		urlTF.setBounds(164, 64, 86, 20);
		getContentPane().add(urlTF);
		urlTF.setColumns(10);
		urlTF.requestFocus();
		
		siteNameTF = new JTextField();
		siteNameTF.setBounds(164, 99, 86, 20);
		getContentPane().add(siteNameTF);
		siteNameTF.setColumns(10);
	}

}
