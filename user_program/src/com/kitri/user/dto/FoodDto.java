package com.kitri.user.dto;

public class FoodDto{
	private int foodNum;
	private String foodName;
	private int foodType;
	private int foodLeftNum;
	private int foodprice;
	private String foodOrder;

	public String getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(String foodOrder) {
		this.foodOrder = foodOrder;
	}

	public int getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodType() {
		return foodType;
	}

	public void setFoodType(int foodType) {
		this.foodType = foodType;
	}

	public int getFoodLeftNum() {
		return foodLeftNum;
	}

	public void setFoodLeftNum(int foodLeftNum) {
		this.foodLeftNum = foodLeftNum;
	}

	public int getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(int foodprice) {
		this.foodprice = foodprice;
	}

}
