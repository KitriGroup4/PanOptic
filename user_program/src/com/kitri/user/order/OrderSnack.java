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

	String snack_name[]={"새우깡 ","카스타드 ","버터링 ","마켓오","마가렛트","로아커","초코송이","쿠쿠다스","제크","구운감자","초코칩","뽀또","칸쵸","오레오","미주라","미주라"};
	String snack_price[] ={"2500원","2500원","3000원","4000원","4000원","4000원","3000원"
			,"2500원","2500원","2500원","2500원","3000원","3000원","3000원","4000원","3000원"};
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
