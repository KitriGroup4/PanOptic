package com.kitri.user.order;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class OrderFood extends JPanel {
	private JButton foodNamebtn[];
	String food_name[]={"������������","�ҺҰ�ⵤ��","��¡���","ī�����̽�","������ ","ġŲ���䵤�� ","��� ","������","����","���","���","�ع����","���ζ��","ġ����","���ζ��","¥����"
			,"��ġ������","��ä������","��ū�쵿","���ο쵿","�ſ�쵿","�Ҽ���������","��ġ�","���ܺ���","¥���"};
	String food_price[] ={"5000��","6000��","5000��","5000��","6000��","6500��","6500��","3000��","4000��","2500��","2500��","3000��","4000��","4000��","4000��","3000��"
			,"5000��","5000��","5000��","5000��","5000��","6000��","6000��","6000��","6000��"};
//	private JPanel contentPane;
	/**
	 * Create the panel.
	 */
	public OrderFood() {
		
//		JPanel panel_2 = new JPanel();
//		contentPane.add(panel_2, BorderLayout.CENTER);
		setLayout(new GridLayout(5, 5, 10, 10));
		
		foodNamebtn = new JButton[25];
		int len = foodNamebtn.length;
		for (int i = 0; i < len; i++) {
			foodNamebtn[i] = new JButton((food_name[i])+"\r"+(food_price[i]));
			add(foodNamebtn[i]);
		}
		
	}

}
