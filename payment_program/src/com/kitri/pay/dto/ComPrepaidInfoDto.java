package com.kitri.pay.dto;

public class ComPrepaidInfoDto {
    private int prepaidNum;
    private float prepaidTime;
    private int prepaidPrice;

    public int getPrepaidNum() {
	return prepaidNum;
    }

    public void setPrepaidNum(int prepaidNum) {
	this.prepaidNum = prepaidNum;
    }

    public float getPrepaidTime() {
	return prepaidTime;
    }

    public void setPrepaidTime(float prepaidTime) {
	this.prepaidTime = prepaidTime;
    }

    public int getPrepaidPrice() {
	return prepaidPrice;
    }

    public void setPrepaidPrice(int prepaidPrice) {
	this.prepaidPrice = prepaidPrice;
    }

}
