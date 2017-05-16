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

public class ListOfBlockedSitesFrame extends JFrame {

	private JPanel contentPane;
	private Vector<String> columnNames;
	private Vector<Vector> rowData;
	public BlockedSitesDto dto;
	
	public RegisterBlockedSiteFrame reg;
	public DeleteBlockedSiteFrame del;
	
	JTable jTable;
	JScrollPane jScollPane;
	
//	String columnNames[] =
//		{ "상품번호", "상품이름", "상품가격", "상품설명" };
//	
//	Object rowData[][] =
//		{
//		{ 1, "맛동산", 100, "오리온" },
//		{ 2, "아폴로", 200, "불량식품" },
//		{ 3, "칸쵸코", 300, "과자계의 레전드" } };


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListOfBlockedSitesFrame frame = new ListOfBlockedSitesFrame();
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
	public ListOfBlockedSitesFrame() {
		super("차단 싸이트 관리");
		reg = new RegisterBlockedSiteFrame(this);
		del = new DeleteBlockedSiteFrame(this);
		
		columnNames = new Vector<String>();
		columnNames.add("번호");
		columnNames.add("싸이트주소");
		columnNames.add("싸이트명");

//Dummy
		dto = new BlockedSitesDto("1", "네이버", "네이버");
		BlockedSitesDto dto2 = new BlockedSitesDto("2", "다음", "다음");
		BlockedSitesDto dto3 = new BlockedSitesDto("3", "딴지", "딴지");
		BlockedSitesDto dto4 = new BlockedSitesDto("4", "벙커", "벙커");
		BlockedSitesDto dto5 = new BlockedSitesDto("5", "오키", "오키");
		
		rowData = new Vector<Vector>();
		rowData.add(dto.getSiteRow());
		rowData.add(dto2.getSiteRow());
		rowData.add(dto3.getSiteRow());
		rowData.add(dto4.getSiteRow());
		rowData.add(dto5.getSiteRow());
//////
		jTable= new JTable(rowData, columnNames);
		jScollPane = new JScrollPane(jTable);	

		System.out.println(rowData.get(0));
		System.out.println(rowData.get(1));
		System.out.println(rowData.get(2));
		System.out.println(rowData.get(3));
		System.out.println(rowData.get(4));

		System.out.println(rowData.get(4).get(0));
		System.out.println(rowData.get(4).get(1));
		System.out.println(rowData.get(4).get(2));
		
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

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		JPanel jtablePanel = new JPanel();
		jtablePanel.setBounds(84, 25, 491, 437);
		mainPanel.add(jtablePanel);
		
		jtablePanel.add(jScollPane);
		
		JButton delete = new JButton("\uC0AD\uC81C");
		delete.setBounds(456, 473, 89, 23);
		mainPanel.add(delete);
		
		JButton register = new JButton("\uB4F1\uB85D");
		register.setBounds(358, 473, 89, 23);
		mainPanel.add(register);
		
		JButton edit = new JButton("\uC218\uC815");
		edit.setBounds(111, 473, 89, 23);
		mainPanel.add(edit);
		
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reg.setVisible(true);
			}
		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				del.setVisible(true);
			}
		});
		
		if (!this.deleteBlockedSite("1111")) { 
			System.out.println("싸이트명을 가진 레코드가 존재하지 않습니다. 삭제 불가능 합니다.");
		}
	}
	
	public void registerBlockedSite (BlockedSitesDto dto) {
		rowData.add(dto.getSiteRow());
	}
	
	public boolean deleteBlockedSite (String siteName) {
		boolean flag = false;
		int size = rowData.size();
		for (int i = 0; i < size; i++) {
			System.out.println("=======================================" + i);
			rowData.get(i);
			System.out.println(rowData.get(i) + "   인덱스 :" + i );
			if (rowData.get(i).get(2).equals(siteName)) {
				System.out.println("싸이트 이름 : " + rowData.get(i).get(2));
				System.out.println("싸이트명이 " + rowData.get(i).get(2) + "인 " + i + "번째 레코드를 삭제 하였습니다.");
				rowData.remove(i);
//삭제된지 확인 후 삭제된 이후 번호 수정된 것인지 확인 함
//				size = rowData.size();
//				for (int j = i; j < size; j++) {
//					rowData.get(j).set(2, (j-1)+"");
//				}
//				for (int j = 0; j < size; j++) {
//					System.out.println("=======================================" + j);
//					rowData.get(j);
//					System.out.println(rowData.get(j) + "   인덱스 :" + j );
//				}

				return true;
			}
		}
		return flag;
	}
}
