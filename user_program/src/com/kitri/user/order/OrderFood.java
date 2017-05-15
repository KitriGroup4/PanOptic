package com.kitri.user.order;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class OrderFood extends JPanel {
	private JButton foodNamebtn[];
	String food_name[]={"매콤제육덮밥","소불고기덮밥","오징어덮밥","카레라이스","육개장 ","치킨마요덮밥 ","돈까스 ","떡볶이","라볶이","김밥","라면","해물라면","만두라면","치즈라면","만두라면","짜장라면"
			,"김치볶음밥","야채볶음밥","얼큰우동","유부우동","매운우동","소세지볶음밥","김치찌개","돌솥비비밤","짜장밥"};
	String food_price[] ={"5000원","6000원","5000원","5000원","6000원","6500원","6500원","3000원","4000원","2500원","2500원","3000원","4000원","4000원","4000원","3000원"
			,"5000원","5000원","5000원","5000원","5000원","6000원","6000원","6000원","6000원"};
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
