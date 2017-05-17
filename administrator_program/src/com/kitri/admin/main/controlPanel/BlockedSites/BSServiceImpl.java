package com.kitri.admin.main.controlPanel.BlockedSites;

public class BSServiceImpl implements BSService {
	// 필요한 메소드 정리
	BSListFrame bsFrame;
	BSDaoServiceImpl daoDb;

	public BSServiceImpl(BSListFrame bsFrame) {
		super();
		this.bsFrame = bsFrame;
	}

	@Override
	public void writeCol() {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeRow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToJtable() {
		// TODO Auto-generated method stub

	}

	@Override
	public String changeQuery(String query) {
		String temp = query;
		return temp;
	}

	@Override
	public void viewReg() {
		bsFrame.reg.setVisible(true);
	}

	@Override
	public void viewDel() {
		bsFrame.del.setVisible(true);
	}
	//
	// public boolean deleteBlockedSite (String siteName) {
	// boolean flag = false;
	// int size = rowData.size();
	// for (int i = 0; i < size; i++) {
	// System.out.println("=======================================" + i);
	// rowData.get(i);
	// System.out.println(rowData.get(i) + " 인덱스 :" + i );
	// if (rowData.get(i).get(2).equals(siteName)) {
	// System.out.println("싸이트 이름 : " + rowData.get(i).get(2));
	// System.out.println("싸이트명이 " + rowData.get(i).get(2) + "인 " + i + "번째 레코드를
	// 삭제 하였습니다.");
	// rowData.remove(i);
	//// 삭제된지 확인 후 삭제된 이후 번호 수정된 것인지 확인 함
	//// size = rowData.size();
	//// for (int j = i; j < size; j++) {
	//// rowData.get(j).set(2, (j-1)+"");
	//// }
	//// for (int j = 0; j < size; j++) {
	//// System.out.println("=======================================" + j);
	//// rowData.get(j);
	//// System.out.println(rowData.get(j) + " 인덱스 :" + j );
	//// }
	//
	// return true;
	// }
	// }
	// return flag;
	// }

}
