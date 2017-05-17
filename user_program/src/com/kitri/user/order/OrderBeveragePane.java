package com.kitri.user.order;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrderBeveragePane extends JPanel {
//	private String beverageName[] ={"아메리카노","카푸치노","카페라떼","카라멜마끼아또","까페모카",
//			"초코라뗴","녹차라떼","고구마라뗴","유자차","복숭아아이스티","레몬아이스티","콜라","사이다","환타","스프라이트","마운틴듀"};
//	private String beveragePrice[] ={"3000원","4000원","3500원","5000원","5000원","3500원","3500원",
//			"3500원","3500원","3500원","4000원","4000원","4000원","4000원","3000원","3000원","3000원"};
//	
	Vector col = new Vector<>();
	Vector rowDatas = new Vector<>();
	JTable table;
	/**
	 * Create the panel.
	 */
	public OrderBeveragePane() {
	col.add("사진");
	col.add("음료메뉴");
	col.add("가격");

	table = new JTable(rowDatas, col);

	JScrollPane scrollPane = new JScrollPane(table);
	add(scrollPane);

	}
	
	private void setRowData() {
		int size = 90;

		Vector temp = new Vector();
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (count < 3) {
				temp.add(i);
				count++;
			} else {
				rowDatas.addElement(temp);
				temp = new Vector();
				count = 0;
			}
			
		}
		
	}

}
