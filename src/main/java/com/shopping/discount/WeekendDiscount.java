package com.shopping.discount;

public class WeekendDiscount implements IDiscount {

	public double getDiscount() {
		return 0.25;
	}

	@Override
	public String toString() {
		return "Weekend Discount";
	}
	
	

}
