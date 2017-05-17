package com.kitri.user.order;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrderFoodPane extends JPanel {

	// String foodName[]={"매콤제육덮밥","소불고기덮밥","오징어덮밥","카레라이스","육개장 ","치킨마요덮밥
	// ","돈까스 ","떡볶이","라볶이","김밥","라면","해물라면","만두라면","치즈라면","만두라면","짜장라면"
	// ,"김치볶음밥","야채볶음밥","얼큰우동","유부우동","매운우동","소세지볶음밥","김치찌개","돌솥비비밤","짜장밥"};
	// String foodPrice[]
	// ={"5000원","6000원","5000원","5000원","6000원","6500원","6500원","3000원","4000원","2500원","2500원","3000원","4000원","4000원","4000원","3000원"
	// ,"5000원","5000원","5000원","5000원","5000원","6000원","6000원","6000원","6000원"};

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	Vector col = new Vector<>();
	Vector rowDatas = new Vector<>();
	JTable table;

	public OrderFoodPane() {
		// String columnNames[] = { "사진", "음식메뉴", "가격" };
		col.add("사진");
		col.add("음식메뉴");
		col.add("가격");
//		setRowData();
//		Vector temp = new Vector();
//		temp.add("img");
//		temp.add("매제");
//		temp.add(5000);
//		rowDatas.addElement(temp);
//		temp = new Vector<>();
//		temp.add("img");
//		temp.add("김치찜");
//		temp.add("25000");
//		rowDatas.addElement(temp);

		// Object rowData[][] = { { "img", "매콤제육덮밥", "5000원" }, { "img",
		// "소불고기덮밥", "6000원" } };

//		 JTable jTable = new JTable(rowData, columnNames);
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
