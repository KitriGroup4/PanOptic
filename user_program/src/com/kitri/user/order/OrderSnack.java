package com.kitri.user.order;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class OrderSnack extends JPanel {

//	private JPanel contentPane;
	/**
	 * Create the panel.
	 */
	JButton SnackNamebtn[];

	String snack_name[]={"����� ","ī��Ÿ�� ","���͸� ","���Ͽ�","������Ʈ","�ξ�Ŀ","���ڼ���","����ٽ�","��ũ","�����","����Ĩ","�Ƕ�","ĭ��","������","���ֶ�","���ֶ�"};
	String snack_price[] ={"2500��","2500��","3000��","4000��","4000��","4000��","3000��"
			,"2500��","2500��","2500��","2500��","3000��","3000��","3000��","4000��","3000��"};
	public OrderSnack() {
		
//		JPanel panel_2 = new JPanel();
//		contentPane.add(panel_2, BorderLayout.CENTER);
		setLayout(new GridLayout(4, 4, 10, 10));
		
		
		SnackNamebtn = new JButton[16];
		int len = SnackNamebtn.length;
		
		for (int i = 0; i < len; i++) {
			SnackNamebtn[i] = new JButton(snack_name[i]+snack_price[i]);
			add(SnackNamebtn[i]);
		}
	}

}
