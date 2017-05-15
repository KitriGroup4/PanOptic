package com.kitri.admin.main.leftoverPanel.LeftOverListFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.admin.main.fixCon.Fix;

import java.awt.Color;

public class LeftOverListFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	JFrame jFrame = new JFrame();

	String columnNames[] =
	{ "음식번호", "음식구분번호", "음식이름", "재고량", "주문처" };

	Object rowData[][] =
	{
	{ "1", "3", "새우깡", "79", "농심" },
	{ "7", "1", "아메리카노", "21", "키트리커피" },
	{ "19", "2", "너구리", "80", "농심" } };

	JTable jTable = new JTable(rowData, columnNames);
	JScrollPane jScollPane = new JScrollPane(jTable);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeftOverListFrame frame = new LeftOverListFrame();
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
	public LeftOverListFrame() {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(0, 0, 677, 542);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBounds(0, 0, 678, 545);
		panel_1.add(panel_2);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\java\\workspace\\javase\\PanOptic\\src\\img\\q1.png"));
		button.setForeground(Color.WHITE);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(631, 25, 30, 27);
		panel_2.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(436, 25, 186, 27);
		panel_2.add(textField);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(17, 60, 644, 479);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollBar scrollBar = new JScrollBar();
		panel_3.add(scrollBar, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("\uC7AC\uACE0\uB7C9");
		lblNewLabel.setBounds(17, 31, 109, 21);
		panel_2.add(lblNewLabel);
		
		panel_3.add(jScollPane);
		
		Fix.FIXFRAME(this);
	}
}
