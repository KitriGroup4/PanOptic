package com.kitri.admin.main.controlPanel.BlockedSites;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BSCon implements ActionListener {
	
	public BSListFrame bsFrame;
	public BSService bsService;
	
	public BSCon(BSListFrame bsFrame) {
		super();
		this.bsFrame = bsFrame;
		bsService = new BSServiceImpl(bsFrame);
		
//		int len = BSConstant.column.length;
//		for (int i = 0; i < len; i++) {
//			bsFrame.columnNames.add(BSConstant.column[i]);
//		}
	}

	// 필요한 listener 정리
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == bsFrame.register) {
			bsFrame.reg.setVisible(true);
		} 
		else if (ob == bsFrame.delete) {
			bsFrame.del.setVisible(true);
		}
		else if (ob == bsFrame.reg.ok || ob == bsFrame.reg.siteNameTF) {
			bsService.insert();
		}
//		else if (ob == bsFrame.reg.urlTF) {
//			bsFrame.del.setVisible(true);
//		}
		else if (ob == bsFrame.del.ok || ob == bsFrame.del.siteNameTF) {
			bsService.delete();
		}
	}
}
