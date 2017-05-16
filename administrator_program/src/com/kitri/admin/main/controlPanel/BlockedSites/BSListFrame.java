package com.kitri.admin.main.controlPanel.BlockedSites;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.kitri.admin.main.fixCon.Fix;

public class BSListFrame extends JFrame {
	public JPanel contentPane;
	public JTable jTable;
	public JScrollPane jScollPane;
	public JPanel mainPanel;
	public JPanel jtablePanel;
	public JButton delete;
	public JButton register;
	public JButton edit;
	
	public BSCon control;
	public BSDb db;
	public RegBS reg;
	public DelBS del;
	
	public Vector<String> columnNames;
	public Vector<Vector> rows;

	public BSListFrame() {
		super("차단 싸이트 관리");
		
		control = new BSCon(this);
		db = new BSDb();
		reg = new RegBS();
		del = new DelBS();
		
		columnNames = new Vector<String>();
		rows = new Vector<Vector> ();
		
		int len = BSConstant.column.length;
		for (int i = 0; i < len; i++) {
			columnNames.add(BSConstant.column[i]);
		}
		
		jTable= new JTable(db.rows, columnNames);
		jScollPane = new JScrollPane(jTable);	

///////////////////////////////////////////////////////////////		
//Test: dto 안에 siteRow 벡터에 생성자에 입력한 값이 들어가는가 하는 Test		
//		int size = dto.getSiteRow().size();
//		
//		for (int i = 0; i < size; i++) {
//			System.out.println(dto.getSiteRow().elementAt(i));
//		}
//		System.out.println(size);
///////////////////////////////////////////////////////////////	
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.addWindowListener(new WindowAdapterExt(this));

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		jtablePanel = new JPanel();
		jtablePanel.setBounds(84, 25, 491, 437);
		mainPanel.add(jtablePanel);
		
		jtablePanel.add(jScollPane);
		
		delete = new JButton("\uC0AD\uC81C");
		delete.setBounds(456, 473, 89, 23);
		mainPanel.add(delete);
		
		register = new JButton("\uB4F1\uB85D");
		register.setBounds(358, 473, 89, 23);
		mainPanel.add(register);
		
		edit = new JButton("\uC218\uC815");
		edit.setBounds(111, 473, 89, 23);
		mainPanel.add(edit);
		Fix.FIXFRAME(this);
		
//		Frame 이벤트
		register.addActionListener(control);
		delete.addActionListener(control);
//		reg 이벤트
		reg.ok.addActionListener(control);
		reg.siteNameTF.addActionListener(control);
		reg.urlTF.addActionListener(control);
//		del 이벤트
		del.ok.addActionListener(control);
		del.siteNameTF.addActionListener(control);
	}
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSListFrame frame = new BSListFrame();
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
}
