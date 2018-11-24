package com.shopping.discount;

public class HappyHoursDiscount implements IDiscount {

	public double getDiscount() {
		
		return 0.30;
	}
	
	@Override
	public String toString() {
		return "Happy Hours Discount";
	}

}
