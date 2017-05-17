package com.kitri.admin.main.controlPanel.BlockedSites;

public class BSDto {
    private int blockedsite_num;
    private String blockedsite_url;
    private String blockedsite_name;
        
	public BSDto() {
		super();
	}
	
	public BSDto(int blockedsite_num, String blockedsite_url, String blockedsite_name) {
		super();
		this.blockedsite_num = blockedsite_num;
		this.blockedsite_url = blockedsite_url;
		this.blockedsite_name = blockedsite_name;
	}
	
	public int getBlockedsite_num() {
		return blockedsite_num;
	}
	public void setBlockedsite_num(int blockedsite_num) {
		this.blockedsite_num = blockedsite_num;
	}
	public String getBlockedsite_url() {
		return blockedsite_url;
	}
	public void setBlockedsite_url(String blockedsite_url) {
		this.blockedsite_url = blockedsite_url;
	}
	public String getBlockedsite_name() {
		return blockedsite_name;
	}
	public void setBlockedsite_name(String blockedsite_name) {
		this.blockedsite_name = blockedsite_name;
	}
}
