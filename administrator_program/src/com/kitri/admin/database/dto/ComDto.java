package com.kitri.admin.database.dto;

public class ComDto {
    private int comNum;
    private int userNum;
    private int isUse;
    private int isBooking;

    public int getComNum() {
	return comNum;
    }

    public void setComNum(int comNum) {
	this.comNum = comNum;
    }

    public int getUserNum() {
	return userNum;
    }

    public void setUserNum(int userNum) {
	this.userNum = userNum;
    }

    public int getIsUse() {
	return isUse;
    }

    public void setIsUse(int isUse) {
	this.isUse = isUse;
    }

    public int getIsBooking() {
	return isBooking;
    }

    public void setIsBooking(int isBooking) {
	this.isBooking = isBooking;
    }
    
    @Override
    public String toString() {
        return comNum + "," + userNum + "," + isUse + "," + isBooking;
    }

}
