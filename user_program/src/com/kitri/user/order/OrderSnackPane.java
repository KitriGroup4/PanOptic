package com.kitri.user.order;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrderSnackPane extends JPanel {

	// String snack_name[]={"새우깡 ","카스타드 ","버터링
	// ","마켓오","마가렛트","로아커","초코송이","쿠쿠다스","제크","구운감자","초코칩","뽀또","칸쵸","오레오","미주라","미주라"};
	// String snack_price[]
	// ={"2500원","2500원","3000원","4000원","4000원","4000원","3000원"
	// ,"2500원","2500원","2500원","2500원","3000원","3000원","3000원","4000원","3000원"};
	/**
	 * Create the panel.
	 */

	Vector col = new Vector<>();
	Vector rowDatas = new Vector<>();
	JTable table;

	public OrderSnackPane() {
		col.add("사진");
		col.add("스낵메뉴");
		col.add("가격");

		JTable jTable = new JTable(rowDatas, col);

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
