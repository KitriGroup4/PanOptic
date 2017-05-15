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
	private JPanel OrderContentsPane;
	private JButton orderFoodbtn;
	private JButton orderSnackbtn;
	private JLabel emptyLabel;
	private JLabel emptyLabel1;
	private JButton pointPaybtn;
	private JLabel totalPriceLabel;
	private JButton orderBeveragebtn;
	private OrderSnack SnackPane;
	private OrderBeverage BeveragePane;
	private OrderFood FoodPane;

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
		CardLayout cl_OrderContentsPane = new CardLayout();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 548);
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
		BackgroundPane.add(OrderContentsPane, BorderLayout.CENTER);

		OrderContentsPane.setLayout(cl_OrderContentsPane);
		FoodPane = new OrderFood();
		BeveragePane = new OrderBeverage();
		SnackPane =  new OrderSnack();
		OrderContentsPane.add(FoodPane,"1");
		OrderContentsPane.add(BeveragePane,"2");
		OrderContentsPane.add(SnackPane,"3");
		
		orderFoodbtn = new JButton("\uC74C\uC2DD");
		OrderMenuPane.add(orderFoodbtn);
		
		orderFoodbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl_OrderContentsPane.show(OrderContentsPane,"1");
				System.out.println("1");
				
			}
		});
		orderSnackbtn = new JButton("\uC2A4\uB0B5");
		OrderMenuPane.add(orderSnackbtn);
		
		orderSnackbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl_OrderContentsPane.show(OrderContentsPane,"3");
				System.out.println("3");
			}
		});

		orderBeveragebtn = new JButton("\uC74C\uB8CC");
		OrderMenuPane.add(orderBeveragebtn);
		
		orderBeveragebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl_OrderContentsPane.show(OrderContentsPane,"2");
				System.out.println(2);
			}
		});
		emptyLabel = new JLabel("");
		OrderMenuPane.add(emptyLabel);
			
		emptyLabel1 = new JLabel("");
		OrderMenuPane.add(emptyLabel1);
		
		totalPriceLabel = new JLabel("\uD569\uACC4:");
		OrderMenuPane.add(totalPriceLabel);
		
		pointPaybtn = new JButton("\uD3EC\uC778\uD2B8\uACB0\uC81C");
		OrderMenuPane.add(pointPaybtn);
		
		setVisible(false);
	}
	
}
