package com.kitri.admin.main.controlPanel.BlockedSites;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BlockedSitesDto {
	private String num;
	private String siteUrl;
	private String siteName;
	private Vector<String> siteRow = new Vector<String>();

	
	public BlockedSitesDto(String num, String siteUrl, String siteName) {
		super();
		
//		siteRow = new Vector<String>();
		siteRow.add(num);
		siteRow.add(siteUrl);
		siteRow.add(siteName);
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Vector<String> getSiteRow() {
		return siteRow;
	}
	
	public void setSiteRow(Vector<String> siteRow) {
		this.siteRow = siteRow;
	}
}
