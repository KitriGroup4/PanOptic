package com.kitri.admin.main.controlPanel.ageRestriction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class AgeRestrictionFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgeRestrictionFrame frame = new AgeRestrictionFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgeRestrictionFrame() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 610);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1998");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 210, 85, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB144\uC0DD \uC774\uC0C1\uC740 10\uC2DC\uAE4C\uC9C0 \uC774\uC6A9 \uAC00\uB2A5 \uD569\uB2C8\uB2E4.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(231, 210, 303, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\uC54C\uB9BC \uD31D\uC5C5\uCC3D \uBCF4\uB0B4\uAE30");
		btnNewButton.setBounds(136, 281, 398, 56);
		contentPane.add(btnNewButton);
		
//		this.addWindowListener(new WindowAdapterExt(this));
	}
}
