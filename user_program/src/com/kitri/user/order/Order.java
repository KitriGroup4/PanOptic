package com.kitri.user.order;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;

public class Order extends JFrame {
	
	private JPanel BackgroundPane;
	private JPanel OrderTitlePane;
	private JLabel order_title_label;
	private JPanel OrderMenuPane;
	public JPanel OrderContentsPane;
	public JButton orderFoodbtn;
	public JButton orderSnackbtn;
	private JLabel emptyLabel;
	private JLabel emptyLabel1;
	public JButton pointPaybtn;
	public JLabel totalPriceLabel;
	public JButton orderBeveragebtn;
	public OrderSnackPane SnackPane;
	public OrderBeveragePane BeveragePane;
	public OrderFoodPane FoodPane;
	public OrderListener listener;
	public CardLayout cl_OrderContentsPane = new CardLayout();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					adf frame = new adf();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Order() {
		listener = new OrderListener(this);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		BackgroundPane = new JPanel();
		BackgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BackgroundPane);
		BackgroundPane.setLayout(new BorderLayout(0, 0));
		
		OrderTitlePane = new JPanel();
		BackgroundPane.add(OrderTitlePane, BorderLayout.NORTH);
		OrderTitlePane.setLayout(new BorderLayout(100, 100));
		
		order_title_label = new JLabel("   Order\t");
		order_title_label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 31));
		OrderTitlePane.add(order_title_label);
		
		OrderMenuPane = new JPanel();
		BackgroundPane.add(OrderMenuPane, BorderLayout.WEST);
		OrderMenuPane.setLayout(new GridLayout(7, 1, 0, 0));
		
		OrderContentsPane = new JPanel();
		
		OrderContentsPane.setLayout(cl_OrderContentsPane);
		BeveragePane = new OrderBeveragePane();
		SnackPane =  new OrderSnackPane();
		FoodPane = new OrderFoodPane();
		OrderContentsPane.add(FoodPane, "1");
		OrderContentsPane.add(BeveragePane,"2");
		OrderContentsPane.add(SnackPane,"3");
		
		BackgroundPane.add(OrderContentsPane, BorderLayout.CENTER);
		
		
		
		
		orderFoodbtn = new JButton("\uC74C\uC2DD");
		OrderMenuPane.add(orderFoodbtn);

		orderSnackbtn = new JButton("\uC2A4\uB0B5");
		OrderMenuPane.add(orderSnackbtn);
		

		orderBeveragebtn = new JButton("\uC74C\uB8CC");
		OrderMenuPane.add(orderBeveragebtn);
		

		emptyLabel = new JLabel("");
		OrderMenuPane.add(emptyLabel);
			
		emptyLabel1 = new JLabel("");
		OrderMenuPane.add(emptyLabel1);
		
		totalPriceLabel = new JLabel("\uD569\uACC4:");
		OrderMenuPane.add(totalPriceLabel);
		
		pointPaybtn = new JButton("\uD3EC\uC778\uD2B8\uACB0\uC81C");
		OrderMenuPane.add(pointPaybtn);
		
		setVisible(false);
		orderFoodbtn.addActionListener(listener);
		orderBeveragebtn.addActionListener(listener);
		orderSnackbtn.addActionListener(listener);
		pointPaybtn.addActionListener(listener);
	}
	
}
