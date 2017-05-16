package com.kitri.admin.main.customerPanel.UserInfoListFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class UserInfoListFrame extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	
	JFrame jFrame = new JFrame();

	String columnNames[] =
	{ "이름", "ID", "E-mail", "주소" };

	Object rowData[][] =
	{
	{ "유정은", "Jung1", "Jung1@naver.com", "서울시 구로구 구로동" },
	{ "김도영", "doyoung", "young@naver.com", "서울시 노원구 공릉동" },
	{ "이창선", "Lee234", "Lee234@gamil.com", "서울시 구로구 구로동" } };

	JTable jTable = new JTable(rowData, columnNames);
	JScrollPane jScollPane = new JScrollPane(jTable);
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfoListFrame frame = new UserInfoListFrame();
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
	public UserInfoListFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 699, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 678, 545);
		contentPane.add(panel);
		
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
		panel_1.setBounds(17, 60, 644, 450);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JComboBox comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		comboBox.setBounds(17, 25, 170, 27);
		panel.add(comboBox);
			
		comboBox.addItem("고객리스트");
		comboBox.addItem("블랙리스트");

		panel_1.add(jScollPane);
		
		JScrollBar scrollBar = new JScrollBar();
		panel_1.add(scrollBar, BorderLayout.EAST);
		
		setResizable(false);
		setLocationRelativeTo(null);

	}

}

