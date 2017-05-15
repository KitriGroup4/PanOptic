package com.kitri.admin.main.managementPanel.WorkWageInfoFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.admin.main.fixCon.Fix;

import java.awt.Color;

public class WorkWageInfoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	JFrame jFrame = new JFrame();

	String columnNames[] =
	{ "이름", "총근무시간", "시급", "급여" };

	Object rowData[][] =
	{
	{ "박수진", "20", "6500", "130000" },
	{ "이동선", "35", "6800", "238000" },
	{ "김수진", "40", "7000", "280000" } };

	JTable jTable = new JTable(rowData, columnNames);
	JScrollPane jScollPane = new JScrollPane(jTable);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkWageInfoFrame frame = new WorkWageInfoFrame();
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
	public WorkWageInfoFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 678, 554);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\uC9C1\uC6D0\uAE09\uC5EC\uC870\uD68C");
		label.setBounds(17, 25, 78, 21);
		panel.add(label);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\java\\workspace\\javase\\PanOptic\\src\\img\\q1.png"));
		button.setForeground(Color.WHITE);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(631, 25, 30, 27);
		panel.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(436, 25, 186, 27);
		panel.add(textField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(17, 60, 644, 479);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollBar scrollBar = new JScrollBar();
		panel_1.add(scrollBar, BorderLayout.EAST);
		
		panel_1.add(jScollPane);
		Fix.FIXFRAME(this);
	}

}
