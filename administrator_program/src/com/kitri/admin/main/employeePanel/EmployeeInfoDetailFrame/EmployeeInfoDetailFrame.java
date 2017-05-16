package com.kitri.admin.main.employeePanel.EmployeeInfoDetailFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Component;

public class EmployeeInfoDetailFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfoDetailFrame frame = new EmployeeInfoDetailFrame();
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
	public EmployeeInfoDetailFrame() {
		setTitle("\uC0C1\uC138\uC815\uBCF4\uC870\uD68C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 478, 614);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(0, 0, 478, 544);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(17, 33, 54, 316);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label = new JLabel("\uC774\uB984");
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("\uC5F0\uB77D\uCC98");
		label_1.setHorizontalTextPosition(SwingConstants.LEFT);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(label_1);
		
		JLabel lblHp = new JLabel("H.P");
		lblHp.setHorizontalTextPosition(SwingConstants.LEFT);
		lblHp.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblHp);
		
		JLabel label_3 = new JLabel("\uC785\uC0AC\uC77C");
		label_3.setHorizontalTextPosition(SwingConstants.LEFT);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("\uD1F4\uC0AC\uC77C");
		label_4.setHorizontalTextPosition(SwingConstants.LEFT);
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(label_4);
		
		JLabel label_2 = new JLabel("\uC9C1\uAE09");
		panel_2.add(label_2);
		
		JLabel label_5 = new JLabel("\uC2DC\uAE09");
		panel_2.add(label_5);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uC18C");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(78, 33, 290, 120);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 0, 5, 5));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_3.add(textField_3);
		
		JButton button_1 = new JButton("\uC815\uBCF4\uC218\uC815");
		button_1.setBounds(17, 375, 171, 29);
		panel_1.add(button_1);
		
		JButton button = new JButton("\uB098\uAC00\uAE30");
		button.setBounds(197, 375, 171, 29);
		panel_1.add(button);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(78, 156, 290, 29);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 3, 5, 5));
		
		JComboBox comboBox_1 = new JComboBox();
		panel_4.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		panel_4.add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_4.add(comboBox_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(78, 192, 290, 29);
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 3, 5, 5));
		
		JComboBox comboBox_3 = new JComboBox();
		panel_5.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		panel_5.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		panel_5.add(comboBox_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(78, 229, 290, 120);
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 0, 5, 5));
		
		JComboBox comboBox_6 = new JComboBox();
		panel_6.add(comboBox_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_6.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_6.add(textField_5);
	}
}
