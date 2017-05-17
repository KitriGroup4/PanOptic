package com.kitri.admin.main.controlPanel.BlockedSites;

public interface BSService {
	void writeCol();
	void writeRow();
	void addToJtable();
	
	String changeQuery(String query);
	
	void viewReg();
	void viewDel();
	
	void insert();
	void delete();
	void update();
}
